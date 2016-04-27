package com.etermax.crackme.notifications.notification.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationDTO {

	@JsonProperty("sender_id")
	private Long senderId;
	@JsonProperty("receiver_id")
	private Long receiverId;
	@JsonProperty("message")
	private String message;
	@JsonProperty(value = "application", defaultValue = "PLAY_CHAT")
	private String application;

	public NotificationDTO(@JsonProperty("sender_id") Long senderId, @JsonProperty("receiver_id") Long receiverId,
			@JsonProperty("message") String message, @JsonProperty("application") String application) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
		this.application = application;
	}

	public Long getSenderId() {
		return senderId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public String getMessage() {
		return message;
	}

	public String getApplication() {
		return application;
	}
}
