package com.tamvan.testaiusingnvidia.chat.controller;

import com.tamvan.testaiusingnvidia.chat.processor.ChatProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatProcessor chatProcessor;

    @PostMapping(value = "/chat", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public HttpEntity<String> chat(@RequestBody String message) {
        log.info(message);
        String response = chatProcessor.generate(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/chat-stream", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public HttpEntity<Flux<String>> chatStream(@RequestBody String message) {
        log.info(message);
        Flux<String> response = chatProcessor.generateStream(message);
        return new ResponseEntity<Flux<String>>(response, HttpStatus.OK);
    }
}
