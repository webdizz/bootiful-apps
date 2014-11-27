package com.epam.itweek.boosenger.repository.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.epam.itweek.boosenger.domain.Message;
import com.epam.itweek.boosenger.repository.MessageRepository;


@Repository
public class RedisMessageRepository implements MessageRepository {

    @Autowired
    private RedisTemplate<String, Message> redisTemplate;

    @Override
    public void createMessage(final String username, final Message message) {
        redisTemplate.boundListOps(username).leftPush(message);
    }

    @Override
    public List<Message> listMessages(final String username) {
        List<Message> messages = new ArrayList<>();
        messages.addAll(redisTemplate.boundListOps(username).range(0, redisTemplate.opsForList().size(username)));
        return messages;
    }
}
