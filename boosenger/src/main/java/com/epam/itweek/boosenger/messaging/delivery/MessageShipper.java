package com.epam.itweek.boosenger.messaging.delivery;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;

import com.epam.itweek.boosenger.domain.Message;

@MessageEndpoint
@Slf4j
public class MessageShipper {

    @Autowired
    private MessagingTemplate messagingTemplate;

    public void ship(final String username, final String content) {
        log.info("Is about to ship message '{}' for user '{}'", content, username);
        Message message = new Message();
        message.setUid(UUID.randomUUID().toString());
        message.setPosted(ZonedDateTime.now());
        message.setContent(content);
        org.springframework.messaging.Message<Message> messageToSend = MessageBuilder.withPayload(message)
                .setHeader("username", username).build();
        messagingTemplate.send("messagingChannel", messageToSend);
    }
}
