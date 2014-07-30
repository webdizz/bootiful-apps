package com.epam.itweek.boosenger.messaging.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessagingTemplate;

@Configuration
@ImportResource("/spring/integration/int-twitter.xml")
@EnableIntegration
public class MessagingConfiguration {

    @Bean
    public MessagingTemplate messagingTemplate() {
        return new MessagingTemplate();
    }
}
