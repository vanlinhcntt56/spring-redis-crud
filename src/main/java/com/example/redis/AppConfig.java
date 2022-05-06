package com.example.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    //Creating Connection with Redis
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    //Creating RedisTemplate for Entity 'Employee'
    @Bean
    public RedisTemplate<String, Employee> redisTemplate() {
        RedisTemplate<String, Employee> employeeRedisTemplate = new RedisTemplate<String, Employee>();
        employeeRedisTemplate.setConnectionFactory(redisConnectionFactory());
        return employeeRedisTemplate;
    }
}