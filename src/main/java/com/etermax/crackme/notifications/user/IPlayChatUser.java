package com.etermax.crackme.notifications.user;

import com.etermax.users.person.IAppUser;

public interface IPlayChatUser extends IAppUser {

	@Override
	public Long getId();

	public String getUsername();
}
