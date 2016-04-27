package com.etermax.crackme.notifications.user.error;

public class PlayChatUserNotFoundException extends Exception {

	private static final String BY_ID_MESSAGE = "No se encontro el usuario con id: ";
	private static final long serialVersionUID = -4559807143643521164L;

	public PlayChatUserNotFoundException(String message) {
		super(message);
	}

	public static PlayChatUserNotFoundException byId(Long userId) {
		return new PlayChatUserNotFoundException(BY_ID_MESSAGE + userId);
	}

}
