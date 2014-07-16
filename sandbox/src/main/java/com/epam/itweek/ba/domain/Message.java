package com.epam.itweek.ba.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class Message implements Serializable {

    private String uid;
    private String message;
    private ZonedDateTime posted;
}
