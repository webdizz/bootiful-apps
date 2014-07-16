package com.epam.itweek.ba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.epam.itweek.ba.domain.Message;

@Repository
public class RedisMessageRepository implements MessageRepository {

    @Autowired
    private RedisTemplate<String, Message> redisTemplate;

    @Override
    public void createMessage(String username, Message message) {
        redisTemplate.boundListOps(username).leftPush(message);
    }

    @Override
    public List<Message> listMessages(String username) {
        List<Message> messages = new ArrayList<>();
        messages.addAll(redisTemplate.boundListOps(username).range(1, redisTemplate.opsForList().size(username)));
        return messages;
    }
}
