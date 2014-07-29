package com.epam.itweek.ba.messaging.delivery;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.support.GenericMessage;

import com.epam.itweek.ba.domain.Message;

@MessageEndpoint
public class MessageShipper {

    @Autowired
    private MessagingTemplate messagingTemplate;

    public void send(final String content) {
        Message message = new Message();
        message.setUid(UUID.randomUUID().toString());
        message.setPosted(ZonedDateTime.now());
        message.setContent(content);
        messagingTemplate.send("messagingChannel", new GenericMessage<Object>(message));
    }
}
