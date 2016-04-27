package com.etermax.crackme.notifications.user.service;

import com.etermax.facebookmanager.domain.IFacebookId;
import com.etermax.users.creation.domain.email.AccountEmail;
import com.etermax.users.find.facebook.IFacebookApplicationService;
import com.etermax.users.person.IEterUser;
import com.etermax.users.person.identifier.FacebookIdentifier;

public class PlaychatFacebookApplicationService implements IFacebookApplicationService {

	@Override
	public IFacebookId findFacebookId(IEterUser eterUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacebookIdentifier createFacebookIdentifier(IFacebookId facebookId, AccountEmail accountEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void linkFacebookId(IFacebookId facebookId, IEterUser eterUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrVerifyAppUserIndex(IEterUser user, IFacebookId facebookId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean existFacebookIndex(IFacebookId facebookId, String applicationPrefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFacebookIndex(IFacebookId facebookId, String applicationPrefix) {
		// TODO Auto-generated method stub
		return null;
	}

}
