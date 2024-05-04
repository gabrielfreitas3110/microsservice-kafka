package com.example.strconsumer.listeners;

import com.example.strconsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListeners {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("\nCREATE ::: Receive message: \n{}.", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("\nLOG ::: Receive message: \n{}.", message);
    }

    @KafkaListener(groupId = "group-2", topics = "{$topic.name}", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("\nHISTORY ::: Receive message: \n{}.", message);
    }
}
