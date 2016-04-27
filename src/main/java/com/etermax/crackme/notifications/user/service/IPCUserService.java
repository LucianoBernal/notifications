package com.etermax.crackme.notifications.user.service;

import com.etermax.crackme.notifications.user.IPlayChatUser;
import com.etermax.crackme.notifications.user.error.PlayChatUserNotFoundException;

public interface IPCUserService {

	void addNewUser(IPlayChatUser user);

	IPlayChatUser findById(Long id) throws PlayChatUserNotFoundException;

	IPlayChatUser findValidatedUser(Long userId);

	Boolean existsUser(Long userId);

}