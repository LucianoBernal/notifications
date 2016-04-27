package com.etermax.crackme.notifications.user.repository;

import com.etermax.crackme.notifications.environment.provider.PCProvider;
import com.etermax.crackme.notifications.jvon.PlayChatSerializator;
import com.etermax.crackme.notifications.user.dao.PlayChatUserDao;
import com.etermax.crackme.notifications.user.domain.PlayChatUser;
import com.etermax.crackme.notifications.user.error.PlayChatUserNotFoundException;
import com.etermax.crackme.notifications.user.IPlayChatUser;
import com.etermax.users.person.IEterUser;
import com.etermax.users.person.exception.UserNotFoundException;
import com.etermax.users.system.environment.Environment;

public class PCUserRepository implements IPCUserRepository {

	@Override
	public void addNewUser(IPlayChatUser user) {
		String serializedUser = PlayChatSerializator.serialize(user);

		getUserDao().saveUser(user.getId(), serializedUser);
	}

	@Override
	public IPlayChatUser findUserById(Long userId) throws PlayChatUserNotFoundException {
		IEterUser eterUser;
		try {
			eterUser = Environment.getSystem().getUserSystem().findUserById(userId);
		} catch (UserNotFoundException e) {
			throw PlayChatUserNotFoundException.byId(userId);
		}
		String result = getUserDao().findUserById(userId);
		if (result != null) {
			PlayChatUser deserialized = PlayChatSerializator.deserialize(result, PlayChatUser.class);
			deserialized.setEterUserForJvonDeserializer(eterUser);
			return deserialized;
		}
		throw PlayChatUserNotFoundException.byId(userId);
	}

	@Override
	public void update(IPlayChatUser user) {
		getUserDao().update(user.getId(), PlayChatSerializator.serialize(user));
	}

	@Override
	public Boolean existsUser(Long userId) {
		return getUserDao().existsUser(userId);
	}

	@Override
	public PlayChatUserDao getUserDao() {
		return PCProvider.getUserDao();
	}

}
