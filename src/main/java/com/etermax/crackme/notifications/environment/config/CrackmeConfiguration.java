package com.etermax.crackme.notifications.environment.config;

import com.etermax.users.system.environment.AppConfigAccessException;
import com.etermax.users.system.environment.IAppConfiguration;
import com.etermax.users.system.environment.ILocationsConfiguration;
import com.etermax.users.system.environment.LocationsConfiguration;
import com.google.common.collect.Maps;

import java.io.InputStream;
import java.util.Map;

public class CrackmeConfiguration implements IAppConfiguration {

	private RedisConfiguration redisConfiguration;
	private Map<String, String> appConfiguration;
	private ILocationsConfiguration locationsConfiguration;

	public CrackmeConfiguration(RedisConfiguration redisConfiguration) {
		this.redisConfiguration = redisConfiguration;
		this.appConfiguration = createConfiguration();
	}

	@Override
	public String getKey(String key) throws AppConfigAccessException {
		return appConfiguration.get(key);
	}

	@Override
	public Boolean hasKey(String key) {
		return appConfiguration.containsKey(key);
	}

	@Override
	public Map<String, String> createConfiguration() {

		Map<String, String> appConfiguration = Maps.newHashMap();

		// Application
		appConfiguration.put("socket.io.servers",
							 "apalabrados.dev.etermax.com:8081:0,apalabrados.dev.etermax.com:8081:1");
		appConfiguration.put("socket.io.password", "B704gs9V169L25P");
		appConfiguration.put("notifications.browser.enable", "true");
		appConfiguration.put("elasticsearch", "disable");
		appConfiguration.put("es.host", "localhost");
		appConfiguration.put("initialize.ES.and.Redis", "disable");
		appConfiguration.put("languages", "ES,EN");
		appConfiguration.put("available_languages", "ES");
		appConfiguration.put("autolink", "false");

		// EMAILS (AMAZON)
		appConfiguration.put("mailKey", "AKIAIMG666E3JLF5H2AA");
		appConfiguration.put("mailSecret", "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");

		// REDIS
		appConfiguration.put("servers", redisConfiguration.getServers());
		appConfiguration.put("timeBetweenEvictionRunsMillis",
							 redisConfiguration.getTimeBetweenEvictionRunsMillis().toString());
		appConfiguration.put("minEvictableIdleTimeMillis",
							 redisConfiguration.getMinEvictableIdleTimeMillis().toString());
		appConfiguration.put("minIdle", redisConfiguration.getMinIdle().toString());
		appConfiguration.put("maxIdle", redisConfiguration.getMaxIdle().toString());
		appConfiguration.put("maxActive", redisConfiguration.getMaxActive().toString());
		appConfiguration.put("maxWait", redisConfiguration.getMaxWait().toString());
		appConfiguration.put("testWhileIdle", redisConfiguration.getTestWhileIdle().toString());
		appConfiguration.put("testOnBorrow", redisConfiguration.getTestOnBorrow().toString());
		appConfiguration.put("timeout", redisConfiguration.getTimeout().toString());
		appConfiguration.put("whenExhaustedAction", "1");
		appConfiguration.put("staticServer", redisConfiguration.getStaticServer());
		appConfiguration.put("password", redisConfiguration.getPassword());

		// FACEBOOK
		appConfiguration.put("facebook.app_id",
							 "126439027467378,131579683612639,200599083317438,342744829135443,145634995501895");

		return appConfiguration;
	}

	@Override
	public ILocationsConfiguration getLocationsConfiguration() {
		if (locationsConfiguration == null)
			locationsConfiguration = new LocationsConfiguration();
		return locationsConfiguration;
	}

	@Override
	public final InputStream getLogConfigurationPath() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		return classLoader.getResourceAsStream("logback2.xml");
	}

}