package com.epam.itweek.ba.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import com.epam.itweek.ba.domain.Message;
import com.epam.itweek.ba.repository.MessageRepository;

@RestController
@RequestMapping("/v1/messages")
@Slf4j
public class MessageRestController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/{username}")
    @ResponseBody
    public Callable<List<Message>> messagesFor(@PathVariable("username") @NotEmpty String username) {
        return () -> messageRepository.listMessages(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public void newMessage(@PathVariable("username") String username, @RequestBody Message message) {
        messageRepository.createMessage(username, message);
    }
}
