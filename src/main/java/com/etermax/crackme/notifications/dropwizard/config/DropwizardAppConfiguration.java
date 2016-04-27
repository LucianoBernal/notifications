package com.etermax.crackme.notifications.dropwizard.config;

import com.etermax.crackme.notifications.environment.config.RedisConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class DropwizardAppConfiguration extends Configuration{

	@JsonProperty("sendInterval")
	private Long sendInterval = 0L;

	@JsonProperty("redis")
	private RedisConfiguration redisConfig;

	@JsonProperty("redis-stats")
	private RedisConfiguration redisStatsConfig;

	public RedisConfiguration getRedisConfig() {
		return redisConfig;
	}

	public RedisConfiguration getRedisStatsConfig() {
		return redisStatsConfig;
	}

	public Long getSendInterval() {
		return sendInterval;
	}
}
