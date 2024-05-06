package com.example.paymentservice.controller.imp;

import com.example.paymentservice.controller.PaymentController;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentService paymentService

    @Override
    public ResponseEntity<Payment> paymentSave(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
