package ru.tinkoff.kafkatesting.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("msg")
public class MessageController {
    public static final String TOPIC_NAME = "msg";
    private final KafkaTemplate<Long, String> kafkaTemplate;

    public MessageController(KafkaTemplate<Long, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMessage(Long id, String message) {
        CompletableFuture<SendResult<Long, String>> future = kafkaTemplate.send(TOPIC_NAME, id, message);
        future.thenAccept(System.out::println);
        kafkaTemplate.flush();
    }
}
