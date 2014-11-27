package com.epam.itweek.boosenger.repository;

import java.util.List;

import com.epam.itweek.boosenger.domain.Message;


public interface MessageRepository {

    void createMessage(String username, Message message);

    List<Message> listMessages(String username);
}
