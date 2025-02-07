package com.abbos.springaiollamachat.service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author Aliabbos Ashurov
 * @since 07/February/2025  11:29
 **/
@Service
public class ChatService {

    private final OllamaChatModel ollamaChatModel;

    public ChatService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public String sendMessage(String message) {
        return ollamaChatModel.call(message);
    }

    public Flux<String> sendMessages(String messages) {
        return ollamaChatModel.stream(messages);
    }
}
