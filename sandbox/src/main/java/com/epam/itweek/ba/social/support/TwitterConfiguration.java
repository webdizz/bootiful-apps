package com.epam.itweek.ba.social.support;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@ConfigurationProperties("spring.social.twitter")
@Data
@Component
public class TwitterConfiguration {

    private String appId;
    private String appSecret;
    private String accessToken;
    private String accessTokenSecret;
}
