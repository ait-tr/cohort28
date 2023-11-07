package org.group28springproject.messageExample;

import org.springframework.context.annotation.Bean;

public class MessageConfig {

    @Bean
    public Message printMessage() {
        return new Message();
    }
}
