package com.sikar.generativeAI;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class GenerativeAIController {

    private final OpenAiChatClient openAiChatClient;
    @GetMapping("/simpleQuery")
    public ResponseEntity<String> getAnswer(@RequestParam String query) {
        return ResponseEntity.ok(openAiChatClient.call(query));
    }
    // prompt and template based request with OpenAI response object
    @GetMapping("/prompt")
    public ResponseEntity<ChatResponse> getAnswer1(@RequestParam String promptContent) {
        Prompt prompt1 = new Prompt(promptContent, ChatOptionsBuilder.builder().withTemperature(1.0f).build());
        return ResponseEntity.ok(openAiChatClient.call(prompt1));
    }


}


