package com.tamvan.testaiusingnvidia.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ChatConfig {

    private final ChatClient.Builder builder;

    @Bean("chatClient")
    public ChatClient chatClient(){
        return builder.build();
    }
}
