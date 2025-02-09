package com.abbos.springaiollamatranslator.controller;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Aliabbos Ashurov
 * @since 08/February/2025  17:29
 **/
@RestController
@RequestMapping("/api/v1/ollama")
public class ChatController {

    private final OllamaChatModel chatModel;

    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/prompt")
    public String chatJsonOutput(@RequestBody Request request) {

        PromptTemplate promptTemplate = new PromptTemplate("""
                Translate {message} from {from} to {to}!
                send only translation and nothing else.
                """);
        Prompt prompt = promptTemplate.create(Map.of("message", request.message(),
                "from", request.fromLang(), "to", request.toLang()));

        return chatModel.call(prompt).getResults().getFirst().getOutput().getContent();
    }
}

record Request(
        String fromLang,
        String toLang,
        String message
) {

}
