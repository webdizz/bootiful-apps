package com.epam.itweek.ba.repository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.epam.itweek.ba.domain.Message;
import com.google.common.base.Strings;

@Repository
public class RedisMessageRepository implements MessageRepository {

    @Autowired
    private RedisTemplate<String, Message> redisTemplate;

    @Override
    public void createMessage(String username, Message message) {
        if (Strings.isNullOrEmpty(message.getUid())) {
            message.setUid(UUID.randomUUID().toString());
        }
        if (message.getPosted() == null) {
            message.setPosted(ZonedDateTime.now());
        }
        redisTemplate.boundListOps(username).leftPush(message);
    }

    @Override
    public List<Message> listMessages(String username) {
        List<Message> messages = new ArrayList<>();
        messages.addAll(redisTemplate.boundListOps(username).range(0, redisTemplate.opsForList().size(username)));
        return messages;
    }
}
