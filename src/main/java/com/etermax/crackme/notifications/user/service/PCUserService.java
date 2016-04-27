package com.etermax.crackme.notifications.user.service;

import com.etermax.apps.error.ApplicationException;
import com.etermax.apps.error.ErrorCode;
import com.etermax.crackme.notifications.environment.provider.PCProvider;
import com.etermax.crackme.notifications.user.error.PlayChatUserNotFoundException;
import com.etermax.crackme.notifications.user.IPlayChatUser;

public class PCUserService implements IPCUserService {

	@Override
	public void addNewUser(IPlayChatUser user) {
		PCProvider.getPlayChatUserRepository().addNewUser(user);
	}

	@Override
	public IPlayChatUser findById(Long id) throws PlayChatUserNotFoundException {
		return PCProvider.getPlayChatUserRepository().findUserById(id);
	}

	@Override
	public IPlayChatUser findValidatedUser(Long userId) {
		try {
			IPlayChatUser player = findById(userId);
			return player;
		} catch (PlayChatUserNotFoundException e) {
			throw new ApplicationException("The user has not been found", ErrorCode.NO_USER);
		}
	}

	@Override
	public Boolean existsUser(Long userId) {
		return PCProvider.getPlayChatUserRepository().existsUser(userId);
	}

}
