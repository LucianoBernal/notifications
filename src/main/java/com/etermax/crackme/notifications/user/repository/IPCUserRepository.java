package com.etermax.crackme.notifications.user.repository;

import com.etermax.crackme.notifications.user.dao.PlayChatUserDao;
import com.etermax.crackme.notifications.user.error.PlayChatUserNotFoundException;
import com.etermax.crackme.notifications.user.IPlayChatUser;

public interface IPCUserRepository {

	void addNewUser(IPlayChatUser user);

	IPlayChatUser findUserById(Long userId) throws PlayChatUserNotFoundException;

	void update(IPlayChatUser user);

	Boolean existsUser(Long userId);

	PlayChatUserDao getUserDao();

}