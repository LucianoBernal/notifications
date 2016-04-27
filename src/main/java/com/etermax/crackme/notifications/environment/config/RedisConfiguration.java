package com.etermax.crackme.notifications.environment.config;

import com.etermax.redis.manager.IRedisConfigurationProvider;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RedisConfiguration implements IRedisConfigurationProvider{

	@JsonProperty
	private String servers;
	@JsonProperty
	private String staticServer;
	@JsonProperty
	private String password;
	@JsonProperty
	private Integer timeBetweenEvictionRunsMillis = 3000;
	@JsonProperty
	private Long minEvictableIdleTimeMillis = 600000L;
	@JsonProperty
	private Integer minIdle = 2;
	@JsonProperty
	private Integer maxIdle = -1;
	@JsonProperty
	private Integer maxActive = 70;
	@JsonProperty
	private Integer maxWait = 10000;
	@JsonProperty
	private Boolean testOnBorrow = false;
	@JsonProperty
	private Boolean testWhileIdle = true;
	@JsonProperty
	private Integer timeout = 0;
	@JsonProperty
	private Integer whenExhaustedAction = 1;


	@Override
	public String getServers() {
		return servers;
	}

	@Override
	public Integer getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	@Override
	public Integer getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis.intValue();
	}

	@Override
	public Integer getMinIdle() {
		return minIdle;
	}

	@Override
	public Integer getMaxIdle() {
		return maxIdle;
	}

	@Override
	public Integer getMaxActive() {
		return maxActive;
	}

	@Override
	public Integer getMaxWait() {
		return maxWait;
	}

	@Override
	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}

	@Override
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	@Override
	public Integer getTimeout() {
		return timeout;
	}

	@Override
	public Boolean getSetBlockWhenExhausted() {
		return whenExhaustedAction.equals(1);
	}

	@Override
	public String getStaticServer() {
		return staticServer;
	}

	@Override
	public String getPassword() {
		return password;
	}
}
