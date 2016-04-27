package com.etermax.crackme.notifications.user.domain;

import com.etermax.jvon.annotations.JvonExclude;
import com.etermax.jvon.annotations.JvonInclude;
import com.etermax.users.converter.CommonUserAdapter;
import com.etermax.users.jvon.UsersSerializator;
import com.etermax.users.system.provider.IApplicationUserAdapter;

@JvonExclude(excludeInherith = true)
@JvonInclude({ "last_log", "join_date", "settings" })
public class PlayChatUserAdapter extends CommonUserAdapter implements IApplicationUserAdapter {

	@Override
	public IApplicationUserAdapter createInstance() {
		return new PlayChatUserAdapter();
	}

	@Override
	public IApplicationUserAdapter deserialize(String serializedAppUser) {
		return UsersSerializator.deserialize(serializedAppUser, PlayChatUserAdapter.class);
	}

}
