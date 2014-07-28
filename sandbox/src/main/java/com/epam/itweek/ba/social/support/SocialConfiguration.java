package com.epam.itweek.ba.social.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class SocialConfiguration {

    @Autowired
    private TwitterConfiguration twitterConfiguration;

    @Bean
    public TwitterTemplate twitterTemplate() {
        return new TwitterTemplate(twitterConfiguration.getAppId(), twitterConfiguration.getAppSecret(),
                twitterConfiguration.getAccessToken(), twitterConfiguration.getAccessTokenSecret());
    }
}
