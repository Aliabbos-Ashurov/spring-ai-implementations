package com.abbos.springaiopenaichat.controller;

import com.abbos.springaiopenaichat.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 07/February/2025  12:09
 **/
@RestController
@RequestMapping("/api/v1/openai")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public String sendMessage(@RequestParam("message") String message) {
        return chatService.sendMessage(message);
    }
}
