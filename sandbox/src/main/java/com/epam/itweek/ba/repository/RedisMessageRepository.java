package com.epam.itweek.ba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisMessageRepository implements MessageRepository {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void createMessage(String username, String message) {
        redisTemplate.boundListOps(username).leftPush(message);
    }

    @Override
    public List<String> listMessages(String username) {
        List<String> messages = new ArrayList<>();
        messages.addAll(redisTemplate.opsForList().range(username, 1, redisTemplate.opsForList().size(username)));
        return messages;
    }
}
