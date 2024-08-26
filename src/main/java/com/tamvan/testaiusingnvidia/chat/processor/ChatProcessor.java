package com.tamvan.testaiusingnvidia.chat.processor;

import reactor.core.publisher.Flux;

public interface ChatProcessor {
    String generate(String message);
    Flux<String> generateStream(String message);
}
