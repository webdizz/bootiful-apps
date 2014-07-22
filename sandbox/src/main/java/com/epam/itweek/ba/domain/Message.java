package com.epam.itweek.ba.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class Message implements Serializable {

    private String uid;
    private String content;
    private ZonedDateTime posted;
}
