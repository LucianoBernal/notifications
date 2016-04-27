package com.etermax.crackme.notifications.jvon;

import com.etermax.jvon.core.JvonServiceCompat;

public class PlayChatSerializator {

	public static <T> T deserialize(String value, Class<T> clazz) {
		return JvonServiceCompat.deserialize(value, clazz);
	}

	public static String serialize(Object object) {
		return JvonServiceCompat.serialize(object);
	}

}
