package com.epam.itweek.ba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.slf4j.Slf4j;

import com.epam.itweek.ba.domain.Message;
import com.epam.itweek.ba.repository.MessageRepository;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/{username}")
    public String createMessage(@PathVariable("username") String username, Model model) {
        model.addAttribute("username", username);
        List<Message> messages = messageRepository.listMessages(username);
        model.addAttribute("messages", messages);
        return "messaging/messages";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public String posMessage(@PathVariable("username") String username, @RequestParam("message") String postedMessage, Model model) {
        Message message = new Message();
        message.setContent(postedMessage);
        messageRepository.createMessage(username, message);
        return "redirect:/" + username;
    }

}
