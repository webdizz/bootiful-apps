package com.epam.itweek.ba.messaging.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

import com.epam.itweek.ba.domain.Message;

@MessageEndpoint
public class TwitterDeliveryHandler implements MessageDeliverable {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    @ServiceActivator
    public org.springframework.messaging.Message<Message> deliver(final org.springframework.messaging.Message<Message> message) {
        Connection<Twitter> twitterConnection = connectionRepository.findPrimaryConnection(Twitter.class);
        Twitter twitter = twitterConnection.getApi();
        if (twitter.isAuthorized()) {
            twitter.timelineOperations().updateStatus(message.getPayload().getContent());
        }
        return message;
    }
}
