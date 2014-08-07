package com.epam.itweek.boosenger.controller;

import java.util.Collections;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;

import com.epam.itweek.boosenger.messaging.delivery.MessageShipper;
import com.epam.itweek.boosenger.repository.MessageRepository;

@Controller
@Slf4j
public class BoosengerController {

    @Autowired
    private MessageShipper messageShipper;

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/{username}")
    public Callable<String> createMessage(@PathVariable("username") String username, Model model) {
        return () -> {
            model.addAttribute("username", username);

            model.addAttribute("messages", messageRepository.listMessages(username));
            return "messaging/messages";
        };
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public Callable<String> posMessage(@PathVariable("username") String username,
                                       @RequestParam("message") String postedMessage) {
        return () -> {
            log.info("Is about to post message '{}' for username: '{}'", postedMessage, username);
            messageShipper.ship(username, postedMessage);
            return "redirect:/" + username;
        };
    }
}
