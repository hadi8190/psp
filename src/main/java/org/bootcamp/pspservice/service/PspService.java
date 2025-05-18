package org.bootcamp.pspservice.service;


import org.bootcamp.pspservice.entity.TransactionDocument;
import org.bootcamp.pspservice.entity.TransactionRequest;
import org.bootcamp.pspservice.enums.TransactionStatus;
import org.bootcamp.pspservice.repository.TransactionRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PspService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TransactionRepository transactionRepository;

    public String handlePurchase(TransactionRequest request) {
        TransactionDocument tx = new TransactionDocument(
                UUID.randomUUID(),
                request.getCardNumber(),
                request.getAmount(),
                request.getMerchantId(),
                TransactionStatus.PENDING
        );
        transactionRepository.save(tx);


            try {
                Object response = rabbitTemplate.convertSendAndReceive("psp-queue", request);
                System.out.println("🟢 پاسخ دریافتی از شاپرک: " + response);

                if (response == null) {
                    tx.setStatus(TransactionStatus.FAILED);
                    transactionRepository.save(tx);
                    return "پاسخی از شاپرک دریافت نشد.";
                }

                try {
                    String statusStr = response.toString(); // مثلاً "SUCCESS"
                    TransactionStatus status = TransactionStatus.valueOf(statusStr); // تبدیل به Enum
                    tx.setStatus(status);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    tx.setStatus(TransactionStatus.FAILED);
                }

                transactionRepository.save(tx);
                return "پاسخ از شاپرک دریافت شد: " + tx.getStatus();

            } catch (Exception e) {
                e.printStackTrace();
                tx.setStatus(TransactionStatus.FAILED);
                transactionRepository.save(tx);
                return "خطای داخلی در سیستم رخ داده است.";
            }
    }
}


