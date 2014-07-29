package com.epam.itweek.ba.messaging.delivery;

import com.epam.itweek.ba.domain.Message;

public interface MessageDeliverable {
    void deliver(Message message);
}
