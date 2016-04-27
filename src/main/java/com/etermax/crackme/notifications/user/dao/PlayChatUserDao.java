package com.etermax.crackme.notifications.user.dao;

import com.etermax.redeez.builder.RedeezKeyBuilder;
import com.etermax.redeez.builder.RedeezOperationDataBuilder;
import com.etermax.redeez.model.RedeezKey;
import com.etermax.redeez.operation.HGetRedeezOperation;
import com.etermax.redeez.operation.HSetRedeezOperation;
import com.etermax.redeez.operation.data.RedeezOperationData;

public class PlayChatUserDao {

	private static final String PC_USR_KEY = "pc:usr:";

	public void saveUser(Long userId, String serializedUser) {
		RedeezKey key = RedeezKeyBuilder.forBaseKey(PC_USR_KEY).build();
		RedeezOperationData operationData = RedeezOperationDataBuilder.forKey(key).optimizedAndShardedBy(userId)
				.buildForWrite(serializedUser);
		new HSetRedeezOperation().execute(operationData);
	}

	public String findUserById(Long userId) {
		RedeezKey redeezKey = RedeezKeyBuilder.forBaseKey(PC_USR_KEY).build();
		RedeezOperationData operationData = RedeezOperationDataBuilder.forKey(redeezKey).optimizedAndShardedBy(userId)
				.buildForRead();
		String result = new HGetRedeezOperation().execute(operationData).result();
		return result;
	}

	public void update(Long userId, String serializedUser) {
		RedeezKey key = RedeezKeyBuilder.forBaseKey(PC_USR_KEY).build();
		RedeezOperationData operationData = RedeezOperationDataBuilder.forKey(key).optimizedAndShardedBy(userId)
				.buildForWrite(serializedUser);
		new HSetRedeezOperation().execute(operationData);
	}

	public Boolean existsUser(Long userId) {
		String user = findUserById(userId);
		return user != null;
	}

}
