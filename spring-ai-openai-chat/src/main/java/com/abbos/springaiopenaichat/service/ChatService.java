package com.abbos.springaiopenaichat.service;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final OpenAiChatModel chatClient;
    private final String prompt;

    public ChatService(OpenAiChatModel chatClient) {
        this.chatClient = chatClient;
        this.prompt = String.format("You have to answer shortly.\nAlways remember my name is: %s", "ABBOS");
    }

    public String sendMessage(String message) {
        String formattedMessage = prompt + "\nUser: " + message;
        return chatClient.call(formattedMessage);
    }
}
