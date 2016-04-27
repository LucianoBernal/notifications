package com.etermax.crackme.notifications.dropwizard.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import com.etermax.redis.initializer.RedisModuleImpl;

public class RedisHealthCheck extends HealthCheck {
	@Override
	protected Result check() throws Exception {
		Boolean healthy = RedisModuleImpl.getInstance()
										 .getJedisService()
										 .testAllRedis()
										 .values()
										 .stream()
										 .reduce((r1, r2) -> r1 && r2)
										 .get();

		return healthy? Result.healthy() : Result.unhealthy("A server is down");
	}
}
