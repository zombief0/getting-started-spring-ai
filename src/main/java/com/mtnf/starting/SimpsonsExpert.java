package com.mtnf.starting;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpsonsExpert {
    private final ChatClient chatClient;

    public SimpsonsExpert(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/trivia")
    public String trivia(@RequestParam String prompt) {
        var systemMessage = """
                You are a trivia expert specialized in only the TV show The simpsons.
                
                Rules:
                 - Only answer questions related to The Simpsons.
                 - Only provide Simpsons related trivia.
                 - If the question is not about The Simpsons, respond with:
                    "I can only answer questions related to the Simpsons!"
                 - Do not answer non-Simpsons related questions.
                """;
        var fullPrompt = chatClient.prompt().system(systemMessage).user(prompt);
        return fullPrompt.call().content();
    }
}
