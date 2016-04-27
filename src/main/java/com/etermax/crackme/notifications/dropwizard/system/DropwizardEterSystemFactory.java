package com.etermax.crackme.notifications.dropwizard.system;

import com.etermax.apps.ApplicationContextWrapper;
import com.etermax.apps.initializer.EterAppsModuleImpl;
import com.etermax.common.provider.CommonModuleImpl;
import com.etermax.crackme.notifications.dropwizard.config.DropwizardAppConfiguration;
import com.etermax.crackme.notifications.environment.config.CrackmeConfiguration;
import com.etermax.crackme.notifications.environment.initializers.CrackmeCommonModuleInitializer;
import com.etermax.crackme.notifications.environment.provider.PlayChatAppProvider;
import com.etermax.crackme.notifications.environment.system.EterSystemFactory;
import com.etermax.devices.provider.DeviceModuleImpl;
import com.etermax.jvon.core.JvonPreProccessor;
import com.etermax.notification.initializer.NotificationModuleImpl;
import com.etermax.redeez.Redeez;
import com.etermax.redis.initializer.RedisModuleImpl;
import com.etermax.redis.key.Keys;
import com.etermax.users.initializer.UserModuleImpl;
import com.etermax.users.system.EterSystem;
import com.etermax.users.system.provider.UsersRedeezConnectionProvider;

public class DropwizardEterSystemFactory implements EterSystemFactory {

	public DropwizardAppConfiguration configuration;

	public DropwizardEterSystemFactory(DropwizardAppConfiguration configuration) {
		this.configuration = configuration;
	}

	private static void initKeys() {
		for (Keys key : Keys.values()) {
			if (key.getApplication() == null) {
				key.setApplication(com.etermax.apps.domain.Application.PLAY_CHAT);
			}
		}
	}

	@Override
	public EterSystem createSystem() throws Exception {
		PlayChatAppProvider appProvider = new PlayChatAppProvider();
		CrackmeConfiguration appConfiguration = new CrackmeConfiguration(configuration.getRedisConfig());
		ApplicationContextWrapper context = new ApplicationContextWrapper(null);

		com.etermax.users.system.environment.Environment.createSystem(appConfiguration, appProvider, context);
		EterSystem system = com.etermax.users.system.environment.Environment.getSystem();

		try {
			EterAppsModuleImpl.initInEagerMode();
			DeviceModuleImpl.initInEagerMode();
			NotificationModuleImpl.initInEagerMode();
			RedisModuleImpl.initInEagerMode(configuration.getRedisConfig(), configuration.getRedisStatsConfig());
			UserModuleImpl.initInEagerMode();
			CommonModuleImpl.initInCustomMode(new CrackmeCommonModuleInitializer());
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		Redeez.create(new UsersRedeezConnectionProvider(appConfiguration));
		initKeys();
		JvonPreProccessor.scan("com.etermax");
		system.start();
		return system;
	}

}
