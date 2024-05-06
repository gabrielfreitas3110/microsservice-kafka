package com.example.paymentservice.controller;


import com.example.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentController {

    @PostMapping
    ResponseEntity<Payment> paymentSave(@RequestBody Payment payment);
}
