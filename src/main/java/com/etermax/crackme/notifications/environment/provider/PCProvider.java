package com.etermax.crackme.notifications.environment.provider;

import com.etermax.crackme.notifications.error.ErrorHandler;
import com.etermax.crackme.notifications.user.dao.PlayChatUserDao;
import com.etermax.crackme.notifications.user.repository.IPCUserRepository;
import com.etermax.crackme.notifications.user.service.IPCUserService;

public class PCProvider {

	private static PCProvider INSTANCE = null;

	private PlayChatAppProvider playChatAppProvider;

	private PCProvider() {
		playChatAppProvider = new PlayChatAppProvider();
	}

	private static PCProvider getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PCProvider();
		return INSTANCE;
	}

	public static void reset() {
		INSTANCE = null;
	}

	public static IPCUserService getPlayChatUserService() {
		return getInstance().getPlayChatAppProvider().getPlayChatUserService();
	}

	public static IPCUserRepository getPlayChatUserRepository() {
		return getInstance().getPlayChatAppProvider().getPlayChatUserRepository();
	}

	public static ErrorHandler getErrorHandler() {
		return getInstance().getPlayChatAppProvider().getErrorHandler();
	}

	public static PlayChatUserDao getUserDao() {
		return getInstance().getPlayChatAppProvider().getUserDao();
	}

	private PlayChatAppProvider getPlayChatAppProvider() {
		return playChatAppProvider;
	}

}
