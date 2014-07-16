package com.epam.itweek.ba.repository;

import java.util.List;

import com.epam.itweek.ba.domain.Message;

public interface MessageRepository {

    void createMessage(String username, Message message);

    List<Message> listMessages(String username);
}
