package com.tamvan.testaiusingnvidia.chat.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ChatProcessorImpl implements ChatProcessor {
    @Qualifier("chatClient")
    private final ChatClient chatClient;

    @Override
    public String generate(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

    @Override
    public Flux<String> generateStream(String message) {
        return chatClient
                .prompt()
                .user(message)
                .stream()
                .content();
    }
}
