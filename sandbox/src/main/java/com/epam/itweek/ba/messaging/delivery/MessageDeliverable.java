package com.epam.itweek.ba.messaging.delivery;

import com.epam.itweek.ba.domain.Message;

public interface MessageDeliverable {
    org.springframework.messaging.Message<Message> deliver(org.springframework.messaging.Message<Message> message);
}
