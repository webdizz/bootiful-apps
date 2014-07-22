package com.epam.itweek.ba.repository.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.epam.itweek.ba.domain.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Message> messageRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Message> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Message> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Message.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setEnableDefaultSerializer(true);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
