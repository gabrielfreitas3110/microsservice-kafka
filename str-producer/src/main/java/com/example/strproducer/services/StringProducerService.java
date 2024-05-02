package com.example.strproducer.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void sendMessage(String message) {
        log.info("\nSend message: \n{}.", message);
        kafkaTemplate.send(topicName, message);
                //.addCallback(
                //        success -> {
                //            if(Objects.nonNull(success)) {
                //                log.info("Send message with success {}.", message);
                //                log.info("Partition {}. Offset {}.",
                //                        success.getRecordMetadata().partition(),
                //                        success.getRecordMetadata().offset());
                //            }
                //        },
                //        error -> log.error("Erro send message.")
                //);
    }
}
