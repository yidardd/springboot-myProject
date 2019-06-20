package com.mr.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisServiceConfig {

    @Value("${redis.task.host}")
    private String redisHost;

    @Value("${redis.task.port}")
    private int redisPort;

    @Value("${redis.task.pass}")
    private String redisPass;

    @Value("${redis.task.db}")
    private int redisDb;

    @Value("${redis.task.config.timeout}")
    private String timeout;
    @Value("${redis.task.config.maxTotal}")
    private int maxTotal;
    @Value("${redis.task.config.maxIdle}")
    private int maxIdle;
    @Value("${redis.task.config.maxWaitMillis}")
    private int maxWaitMillis;
    @Value("${redis.task.config.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;
    @Value("${redis.task.config.numTestsPerEvictionRun}")
    private int numTestsPerEvictionRun;
    @Value("${redis.task.config.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${redis.task.config.testOnBorrow}")
    private Boolean testOnBorrow;
    @Value("${redis.task.config.testWhileIdle}")
    private Boolean testWhileIdle;

    @Bean
    @Primary
    public RedisConnectionFactory taskConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(redisPort);
        connectionFactory.setHostName(redisHost);
        connectionFactory.setDatabase(redisDb);
//        connectionFactory.setPassword(redisPass);

        //配置连接池属性
        connectionFactory.setTimeout(Integer.parseInt(timeout));
        connectionFactory.getPoolConfig().setMaxIdle(maxIdle);
        connectionFactory.getPoolConfig().setMaxTotal(maxTotal);
        connectionFactory.getPoolConfig().setMaxWaitMillis(maxWaitMillis);
        connectionFactory.getPoolConfig().setMinEvictableIdleTimeMillis(Integer.parseInt(minEvictableIdleTimeMillis));
        connectionFactory.getPoolConfig().setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        connectionFactory.getPoolConfig().setTimeBetweenEvictionRunsMillis(Integer.parseInt(timeBetweenEvictionRunsMillis));
        connectionFactory.getPoolConfig().setTestOnBorrow(testOnBorrow);
        connectionFactory.getPoolConfig().setTestWhileIdle(testWhileIdle);

        return connectionFactory;
    }

    @Bean
    public StringRedisTemplate taskRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(taskConnectionFactory());
        return template;
    }

}