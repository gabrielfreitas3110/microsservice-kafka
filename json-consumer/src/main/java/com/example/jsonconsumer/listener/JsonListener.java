package com.example.jsonconsumer.listener;


import com.example.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "{$topic.name}", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment) {
        log.info("Recebi o pagamento {}", payment);
        sleep(2000);
        log.info("Validando fraude...");
        sleep(2000);
        log.info("Compra aprovada...");
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "{$topic.name}", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        log.info("Gerando pdf do produto de id {}...", payment.getId());
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "{$topic.name}", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        log.info("Enviando email de confirmação...");
    }
}
