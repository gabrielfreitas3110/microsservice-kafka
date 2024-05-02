package com.example.strconsumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListeners {

    @KafkaListener(groupId = "group-1", topics = "${topic.name}", containerFactory = "containerFactory")
    public void create(String message) {
        log.info("\nCREATE ::: Receive message: \n{}.", message);
    }

    @KafkaListener(groupId = "group-1", topics = "${topic.name}", containerFactory = "containerFactory")
    public void log(String message) {
        log.info("\nLOG ::: Receive message: \n{}.", message);
    }
}
