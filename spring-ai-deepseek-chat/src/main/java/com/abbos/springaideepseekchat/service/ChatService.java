package com.abbos.springaideepseekchat.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author Aliabbos Ashurov
 * @since 07/February/2025  10:17
 **/
@Service
public class ChatService {

    private final OpenAiChatModel chatClient;

    public ChatService(OpenAiChatModel chatClient) {
        this.chatClient = chatClient;
    }

    public String sendMessage(String message) {
        return chatClient
                .call(message);
    }

    public Flux<String> sendMessageFlux(String message) {
        return chatClient
                .stream(message);
    }
}
