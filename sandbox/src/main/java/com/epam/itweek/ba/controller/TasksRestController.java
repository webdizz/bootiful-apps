package com.epam.itweek.ba.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@Slf4j
public class TasksRestController {

    @RequestMapping("/tasks")
    @ResponseBody
    public String listTasks() {
        log.info("Is about to list task");
        return "Hello";
    }
}
