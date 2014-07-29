package com.epam.itweek.ba.messaging.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.epam.itweek.ba.domain.Message;
import com.epam.itweek.ba.repository.MessageRepository;

@Component
public class RedisPersistentDeliveryHandler implements MessageDeliverable {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @ServiceActivator
    public org.springframework.messaging.Message<Message> deliver(
            final org.springframework.messaging.Message<Message> message) {
        messageRepository.createMessage(message.getHeaders().get("username", String.class), message.getPayload());
        return message;
    }
}
