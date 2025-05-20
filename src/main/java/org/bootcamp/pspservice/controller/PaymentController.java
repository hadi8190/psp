package org.bootcamp.pspservice.controller;

import jakarta.validation.Valid;
import org.bootcamp.pspservice.entity.RemainingRequest;
import org.bootcamp.bankservice.entity.RemainingResponse;
import org.bootcamp.pspservice.entity.TransactionRequest;
import org.bootcamp.pspservice.service.PaymentService;
import org.bootcamp.shaparakservice.entity.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/psp")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<TransactionResponse> handlePayment(@RequestBody @Valid TransactionRequest request) {
        TransactionResponse response = paymentService.processTransaction(request);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/remaining")
    public ResponseEntity<RemainingResponse> handlePaymentRamaining(@RequestBody @Valid RemainingRequest request) {
        RemainingResponse response = paymentService.remaining(request);
        return ResponseEntity.ok(response);
    }

}

