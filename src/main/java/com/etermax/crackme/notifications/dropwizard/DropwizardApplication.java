package com.etermax.crackme.notifications.dropwizard;

import com.etermax.crackme.notifications.dropwizard.config.DropwizardAppConfiguration;
import com.etermax.crackme.notifications.dropwizard.healthcheck.RedisHealthCheck;
import com.etermax.crackme.notifications.dropwizard.system.DropwizardEterSystemFactory;
import com.etermax.crackme.notifications.notification.rest.NotificationsResource;
import com.etermax.crackme.notifications.notification.service.PlayChatNotificationService;
import com.etermax.users.system.EterSystem;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class DropwizardApplication extends Application<DropwizardAppConfiguration> {

	public static void main(String[] args) throws Exception {
		new DropwizardApplication().run(args);
	}

	public static EterSystem createSystem(DropwizardAppConfiguration configuration) throws Exception {
		return new DropwizardEterSystemFactory(configuration).createSystem();
	}

	@Override
	public void run(DropwizardAppConfiguration configuration, Environment environment) throws Exception {
		printBanner();
		createSystem(configuration);
		registerResources(environment, configuration);
		registerHealthChecks(environment);
	}

	private void registerHealthChecks(Environment environment) {
		environment.healthChecks().register("redis", new RedisHealthCheck());
	}

	private void registerResources(Environment environment, DropwizardAppConfiguration configuration) {
		environment.jersey().register(new NotificationsResource(getService(configuration)));
	}

	private PlayChatNotificationService getService(DropwizardAppConfiguration configuration) {
		return new PlayChatNotificationService(configuration.getSendInterval());
	}

	private void printBanner() throws IOException {
		InputStream logo = this.getClass().getClassLoader().getResourceAsStream("logo.txt");
		System.out.println(IOUtils.toString(logo, "UTF-8"));
	}

}
