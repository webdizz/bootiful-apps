package com.epam.itweek.boosenger.messaging.delivery;

import org.springframework.integration.annotation.ServiceActivator;

import com.epam.itweek.boosenger.domain.Message;

public interface MessageDeliverable {
    @ServiceActivator
    org.springframework.messaging.Message<Message> deliver(
            org.springframework.messaging.Message<Message> message);
}
