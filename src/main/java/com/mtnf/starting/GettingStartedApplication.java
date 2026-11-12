package com.mtnf.starting;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GettingStartedApplication implements CommandLineRunner {

    @Autowired
    ChatClient.Builder builder;

    @Override
    public void run(String... args) throws Exception {
        var chatClient = builder.build();
        var prompt = chatClient.prompt("Tell me a joke about Spring Boot");
        IO.println("Prompt:");
        ChatClient.CallResponseSpec call = prompt.call();

        IO.println(call.content());
    }

    static void main(String[] args) {
        SpringApplication.run(GettingStartedApplication.class, args);
    }

}
