package org.bootcamp.pspservice.controller;

import jakarta.validation.Valid;
import org.bootcamp.pspservice.dto.TransactionRequestDTO;
import org.bootcamp.pspservice.dto.TransactionResponseDTO;
import org.bootcamp.pspservice.entity.TransactionRequest;
import org.bootcamp.pspservice.service.PspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/psp")
public class TransactionController {

    @Value("${jasypt.encryptor.password}")
    private String encryptKey;

    @Autowired
    private PspService pspService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionRequest request) {
        System.out.println(" :شماره کارت" +request.getCardNumber());
        System.out.println(" :مبلغ" + request.getAmount());
        System.out.println(" :پذیرنده" + request.getMerchantId());


//        StrongTextEncryptor encryptor = new StrongTextEncryptor();
//        encryptor.setPassword(encryptKey);
//        String encryptedPassword = encryptor.encrypt(tra.getPassword());
//        System.out.println("Encrypted Password: " + encryptedPassword);
        String response = pspService.handlePurchase(request);
        return ResponseEntity.ok(response);
    }
}

