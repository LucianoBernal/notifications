package com.etermax.crackme.notifications.environment.provider;

import com.etermax.apps.domain.Language;
import com.etermax.apps.service.Ii18nTextProvider;
import com.etermax.crackme.notifications.error.ErrorHandler;
import com.etermax.crackme.notifications.error.ErrorHandlerBuilder;
import com.etermax.crackme.notifications.user.dao.PlayChatApplicationUserDao;
import com.etermax.crackme.notifications.user.dao.PlayChatUserDao;
import com.etermax.crackme.notifications.user.domain.PlayChatUserAdapter;
import com.etermax.crackme.notifications.user.repository.IPCUserRepository;
import com.etermax.crackme.notifications.user.repository.PCUserRepository;
import com.etermax.crackme.notifications.user.service.PCUserService;
import com.etermax.crackme.notifications.user.service.PlaychatFacebookApplicationService;
import com.etermax.crackme.notifications.user.service.IPCUserService;
import com.etermax.users.appinfo.AppInfoService;
import com.etermax.users.appinfo.IAppInfoService;
import com.etermax.users.creation.dao.IApplicationUserDao;
import com.etermax.users.find.IApplicationUserIdFinder;
import com.etermax.users.find.facebook.IFacebookApplicationService;
import com.etermax.users.notifications.email.provider.IEmailTemplateProvider;
import com.etermax.users.system.provider.IAppProvider;
import com.etermax.users.system.provider.IApplicationUserAdapter;

public class PlayChatAppProvider implements IAppProvider {

	private IApplicationUserDao playChatApplicationUserDao;
	private PlayChatUserAdapter playChatUserAdapter;
	private IPCUserRepository playChatUserRepository;
	private IPCUserService playChatUserService;
	private PlayChatUserDao userDao;
	private ErrorHandler errorHandler;
	private AppInfoService appInfoService;
	private IFacebookApplicationService playchatFacebookApplicationService;

	public PlayChatAppProvider() {
		playChatApplicationUserDao = new PlayChatApplicationUserDao();
		playChatUserAdapter = new PlayChatUserAdapter();
		playChatUserService = new PCUserService();
		playChatUserRepository = new PCUserRepository();
		userDao = new PlayChatUserDao();
		errorHandler = createErrorHandler();
		appInfoService = new AppInfoService();
		playchatFacebookApplicationService = new PlaychatFacebookApplicationService();
	}

	private ErrorHandler createErrorHandler() {
		ErrorHandlerBuilder builder = new ErrorHandlerBuilder();
		return builder.build();
	}

	@Override
	public IApplicationUserDao getApplicationUserDao() {
		return playChatApplicationUserDao;
	}

	@Override
	public IApplicationUserAdapter getApplicationAdapter() {
		return playChatUserAdapter;
	}

	public IPCUserService getPlayChatUserService() {
		return playChatUserService;
	}

	public IPCUserRepository getPlayChatUserRepository() {
		return playChatUserRepository;
	}

	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	public PlayChatUserDao getUserDao() {
		return userDao;
	}

	@Override
	public IAppInfoService getAppInfoService() {
		return appInfoService;
	}

	@Override
	public IEmailTemplateProvider getEmailTemplateProvider() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public IFacebookApplicationService getFacebookApplicationService() {
		return playchatFacebookApplicationService;
	}

	@Override
	public IApplicationUserIdFinder getApplicationUserFinder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ii18nTextProvider getIi18nTextProvider() {
		return new Ii18nTextProvider() {
			@Override
			public String getText(Language l, String key) {
				return "Notification";
			}
		};
	}

}
