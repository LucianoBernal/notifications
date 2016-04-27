package com.etermax.crackme.notifications.notification.service;

import com.etermax.apps.domain.Application;
import com.etermax.apps.domain.Language;
import com.etermax.common.provider.CommonModuleImpl;
import com.etermax.common.xnotification.model.NewMessageNotification;
import com.etermax.common.xnotification.service.INotificationService;
import com.etermax.crackme.notifications.notification.rest.NotificationDTO;
import com.etermax.users.accesslocation.domain.UserAccessInfo;
import com.etermax.users.accesslocation.service.IUserAccessService;
import com.etermax.users.creation.domain.IUserSystem;
import com.etermax.users.notifications.NotificableProfile;
import com.etermax.users.person.exception.UserNotFoundException;
import com.etermax.users.system.environment.Environment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayChatNotificationService {

	private final ExecutorService executorService;
	private Long sendInterval;

	public PlayChatNotificationService(Long sendInterval) {
		this.sendInterval = sendInterval;
		this.executorService = Executors.newFixedThreadPool(100);
	}

	public void sendNotification(NotificationDTO dto) throws UserNotFoundException {
		Application application = getApplication(dto);
		NotificableProfile sender = getUser(dto.getSenderId(), application);
		NotificableProfile receiver = getUser(dto.getReceiverId(), application);
		NewMessageNotification notification = new NewMessageNotification(receiver, sender, Language.ES, application,
																		 100L, dto.getMessage(), 0L);

		executorService.execute(() -> {
			try {
				Thread.sleep(sendInterval);
			} catch (InterruptedException ignored) {
			} finally {
				getNotificationService().send(notification);
			}
		});
	}

	private NotificableProfile getUser(Long id, Application applicationToSend) throws UserNotFoundException {
		return new NotificableProfile(getUserSystem().findUserById(id), fromOldApplication(applicationToSend));
	}

	private INotificationService getNotificationService() {
		return CommonModuleImpl.getInstance().getNotificationService();
	}

	private IUserSystem getUserSystem() {
		return Environment.getSystem().getUserSystem();
	}

	private Application getDestinationApp(final Long receiverUserId, Application application) {
		return getDestinationApp(application, getUserAccessService().safeGetLastAccess(receiverUserId));
	}

	private Application getDestinationApp(Application application, UserAccessInfo lastAccess) {
		Application destinationApp = lastAccess.getLastAccessApp();
		if (userHasNoApplication(destinationApp)) {
			destinationApp = application;
		}
		return destinationApp;
	}

	private Application getApplication(NotificationDTO dto) {
		try {
			if (dto.getApplication().equals(Application.PLAY_CHAT.name())) {
				return getDestinationApp(dto.getReceiverId(), Application.PLAY_CHAT);
			} else {
				return Application.valueOf(dto.getApplication());
			}
		} catch (Exception e) {
			return getDestinationApp(dto.getReceiverId(), Application.PLAY_CHAT);
		}
	}

	private boolean userHasNoApplication(Application destinationApp) {
		return destinationApp == null;
	}

	private IUserAccessService getUserAccessService() {
		return Environment.getSystem().getUserSystem().getProvider().getUserAccessService();
	}

	private com.etermax.users.system.application.Application fromOldApplication(Application applicationToSend) {
		return com.etermax.users.system.application.Application.fromOldApplicationEnum(applicationToSend);
	}

}
