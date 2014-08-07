package com.epam.itweek.boosenger.messaging.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.epam.itweek.boosenger.domain.Message;
import com.epam.itweek.boosenger.repository.MessageRepository;


@Component
@Slf4j
public class RedisPersistentDeliveryHandler implements MessageDeliverable {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @ServiceActivator
    public org.springframework.messaging.Message<Message> deliver(
            final org.springframework.messaging.Message<Message> message) {
        log.info("Is about to deliver message to Redis database");
        messageRepository.createMessage(message.getHeaders().get("username", String.class), message.getPayload());
        return message;
    }
}
