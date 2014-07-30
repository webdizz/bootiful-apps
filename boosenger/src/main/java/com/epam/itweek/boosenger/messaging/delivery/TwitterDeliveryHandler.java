package com.epam.itweek.boosenger.messaging.delivery;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

import com.epam.itweek.boosenger.domain.Message;


@MessageEndpoint
@Slf4j
public class TwitterDeliveryHandler {

    @Autowired
    private ConnectionRepository connectionRepository;

    @ServiceActivator
    public org.springframework.messaging.Message<Message> deliver(
            final org.springframework.messaging.Message<Message> message) {
        log.info("Is about to deliver message to Twitter");
        Connection<Twitter> twitterConnection = connectionRepository.findPrimaryConnection(Twitter.class);
        Twitter twitter = twitterConnection.getApi();
        if (twitter.isAuthorized()) {
            twitter.timelineOperations().updateStatus(message.getPayload().getContent());
        } else {
            log.error("Twitter is not authorized");
        }
        return message;
    }
}
