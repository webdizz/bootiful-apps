package com.epam.itweek.ba.repository.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.epam.itweek.ba.domain.Message;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Message> messageRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Message> redisTemplate = new RedisTemplate<>();
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Message.class));
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
