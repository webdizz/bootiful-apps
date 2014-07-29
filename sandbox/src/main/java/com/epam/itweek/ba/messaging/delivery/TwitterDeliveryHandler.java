package com.epam.itweek.ba.messaging.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;

import com.epam.itweek.ba.domain.Message;

@MessageEndpoint
public class TwitterDeliveryHandler implements MessageDeliverable {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public void deliver(final Message message) {
        Connection<Twitter> twitterConnection = connectionRepository.findPrimaryConnection(Twitter.class);
        Twitter twitter = twitterConnection.getApi();
        if (twitter.isAuthorized()) {
            twitter.timelineOperations().updateStatus(message.getContent());
        }
    }
}
