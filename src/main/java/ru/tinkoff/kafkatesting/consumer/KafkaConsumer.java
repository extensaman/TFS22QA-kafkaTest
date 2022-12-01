package ru.tinkoff.kafkatesting.consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import ru.tinkoff.kafkatesting.controller.MessageController;
import ru.tinkoff.kafkatesting.entity.Car;

@EnableKafka
@Configuration
public class KafkaConsumer {

    @KafkaListener(topics = MessageController.TOPIC_NAME)
    public void listenMessage(ConsumerRecord<Long, Car> record){
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
    }
}
