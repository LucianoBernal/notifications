package com.etermax.crackme.notifications.user.dao;

import java.util.Collection;
import java.util.List;

import com.etermax.redeez.builder.RedeezKeyBuilder;
import com.etermax.redeez.builder.RedeezOperationDataBuilder;
import com.etermax.redeez.model.RedeezKey;
import com.etermax.redeez.operation.HGetRedeezOperation;
import com.etermax.redeez.operation.HSetRedeezOperation;
import com.etermax.redeez.operation.data.RedeezOperationData;
import com.etermax.users.creation.dao.IApplicationUserDao;
import com.etermax.users.utils.redeez.RedeezResponseForUserPreferences;

public class PlayChatApplicationUserDao implements IApplicationUserDao {

	public static final String USER_KEY_PATTERN = "pc:usr:";

	@Override
	public String findAppUser(Long userId) {
		RedeezKey redeezKey = RedeezKeyBuilder.forBaseKey(USER_KEY_PATTERN).build();
		RedeezOperationData data = RedeezOperationDataBuilder.forKey(redeezKey).optimizedAndShardedBy(userId)
				.buildForRead();
		return new HGetRedeezOperation().execute(data).result();
	}

	@Override
	public void saveAppUser(Long userId, String serializedUser) {
		RedeezKey redeezKey = RedeezKeyBuilder.forBaseKey(USER_KEY_PATTERN).build();
		RedeezOperationData data = RedeezOperationDataBuilder.forKey(redeezKey).optimizedAndShardedBy(userId)
				.buildForWrite(serializedUser);
		new HSetRedeezOperation().execute(data);
	}

	@Override
	public List<RedeezResponseForUserPreferences> findAppUsers(Collection<Long> usersId) {
		// TODO Auto-generated method stub
		return null;
	}

}
