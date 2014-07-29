package com.epam.itweek.ba.controller;

import java.util.List;
import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.itweek.ba.domain.Message;
import com.epam.itweek.ba.messaging.delivery.MessageShipper;
import com.epam.itweek.ba.repository.MessageRepository;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageShipper messageShipper;

    @RequestMapping("/{username}")
    public Callable<String> createMessage(@PathVariable("username") String username, Model model) {
        return () -> {
            model.addAttribute("username", username);
            List<Message> messages = messageRepository.listMessages(username);
            model.addAttribute("messages", messages);
            return "messaging/messages";
        };
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public Callable<String> posMessage(@PathVariable("username") String username,
            @RequestParam("message") String postedMessage) {
        return () -> {
            messageShipper.send(postedMessage);
            return "redirect:/" + username;
        };
    }

}
