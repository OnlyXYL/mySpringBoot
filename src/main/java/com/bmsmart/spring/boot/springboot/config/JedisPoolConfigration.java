package com.bmsmart.spring.boot.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:redis_common.properties")
public class JedisPoolConfigration {

    @Value("${redis.maxTotal}")
    private int maxTotal;

    @Value("${redis.maxIdle}")
    private int maxIdle;

    @Value("${redis.maxWaitMillis}")
    private long maxWaitMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Bean
    public redis.clients.jedis.JedisPoolConfig jedisPoolConfig() {
        redis.clients.jedis.JedisPoolConfig jedisPoolConfig = new redis.clients.jedis.JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }
}
