package com.etermax.crackme.notifications.notification.rest;

import com.etermax.crackme.notifications.notification.service.PlayChatNotificationService;
import com.etermax.users.person.exception.UserNotFoundException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/notifications")
@Produces("application/json")
public class NotificationsResource {

	private PlayChatNotificationService service;

	public NotificationsResource(PlayChatNotificationService service) {
		this.service = service;
	}

	@POST
	public NotificationDTO sendNotification(NotificationDTO notificationDTO) throws UserNotFoundException {
		service.sendNotification(notificationDTO);
		return notificationDTO;
	}

}
