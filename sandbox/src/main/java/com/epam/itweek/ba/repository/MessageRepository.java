package com.epam.itweek.ba.repository;

import java.util.List;

public interface MessageRepository {
    void createMessage(String username, String message);

    List<String> listMessages(String username);
}
