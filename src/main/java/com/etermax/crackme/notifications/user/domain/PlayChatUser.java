package com.etermax.crackme.notifications.user.domain;

import java.util.Date;

import org.joda.time.DateTime;

import com.etermax.crackme.notifications.user.IPlayChatUser;
import com.etermax.users.person.IEterUser;
import com.etermax.users.person.IUserGameStats;

public class PlayChatUser implements IPlayChatUser {

	private IEterUser eterUser;

	public PlayChatUser(IEterUser user) {
		this.eterUser = user;
	}

	@Deprecated
	public PlayChatUser() {
		// Para Jvon
	}

	@Override
	public String getUsername() {
		return eterUser.getUserName();
	}

	@Override
	public Long getId() {
		return eterUser.getId();
	}

	public void setEterUserForJvonDeserializer(IEterUser eterUser) {
		this.eterUser = eterUser;
	}

	@Override
	public Long getCoins() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public void setCoins(Long coins) {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public IUserGameStats getUserStats() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public Date getLastLog() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public DateTime getJoinDate() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public void addCoins(Long coinsToAdd) {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public void subtractCoins(Long coinsToDiscount) {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public void initializeAndSave() {
		throw new RuntimeException("Autogenerated code. Must complete!!!");
	}

	@Override
	public IEterUser getEterUser() {
		return eterUser;
	}

	@Override
	public String _getType() {
		return "pc_usr";
	}

}
