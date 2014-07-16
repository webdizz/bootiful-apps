package com.epam.itweek.ba.controller;

import lombok.extern.slf4j.Slf4j;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.javafx.tools.packager.Log;

@RestController
@Slf4j
public class MessagingRestController {

    @RequestMapping("/{username}")
    @ResponseBody
    public String messagesFor(@PathVariable("username") @NotEmpty String username) {
        log.info("Is about to list messages");
        return "Hello, " + username;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public void newMessage(@PathVariable("username") String username, String message) {
        log.info("Is about to create new message");
    }
}
