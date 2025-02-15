package com.abbos.springaigeminichat.service;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Aliabbos Ashurov
 * @since 11/February/2025  11:31
 **/
@RestController
@RequestMapping("/api/v1/gemini")
public class ChatController {

    // gemini requires google default credentials
    private final VertexAiGeminiChatModel geminiChatModel;

    public ChatController(VertexAiGeminiChatModel geminiChatModel) {
        this.geminiChatModel = geminiChatModel;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {

        PromptTemplate promptTemplate = new PromptTemplate("""
                Just answer shortly. I don't need extra informations.
                req: {message}
                """);
        Prompt prompt = promptTemplate.create(Map.of("message", message));

        return geminiChatModel.call(prompt)
                .getResult()
                .getOutput()
                .getContent();

    }

}