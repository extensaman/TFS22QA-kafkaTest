package ru.tinkoff.kafkatesting.consumer;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import ru.tinkoff.kafkatesting.controller.MessageController;

@EnableKafka
public class KafkaConsumer {

    @KafkaListener(topics = MessageController.TOPIC_NAME, groupId = "lopata")
    public void listenMessage(String message){
        System.out.println(message);
    }
}
