package com.abbos.springaideepseekchat.controller;

import com.abbos.springaideepseekchat.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 07/February/2025  10:16
 **/
@RestController
@RequestMapping("/api/v1/deep-seek")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public String request(@RequestParam String message) {
        return chatService.sendMessage(message);
    }
}
