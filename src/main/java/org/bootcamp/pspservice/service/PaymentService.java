package org.bootcamp.pspservice.service;

import org.bootcamp.pspservice.entity.RemainingRequest;
import org.bootcamp.bankservice.entity.RemainingResponse;
import org.bootcamp.pspservice.entity.Transaction;
import org.bootcamp.pspservice.entity.TransactionRequest;
import org.bootcamp.pspservice.enums.TransactionStatus;
import org.bootcamp.pspservice.repository.MerchantRepository;
import org.bootcamp.pspservice.repository.TransactionRepository;
import org.bootcamp.shaparakservice.entity.TransactionResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public TransactionResponse processTransaction(TransactionRequest request) {

        // چک کردن وجود پذیرنده
//        Merchant merchant = merchantRepository.findMerchantsBy(request.getMerchantId())
//                .orElseThrow(() -> new MerchantNotFoundException("شناسه پذیرنده یافت نشد."));


        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setCardNumber(request.getCardNumber());
        transaction.setAmount(request.getAmount());
        transaction.setMerchantId(request.getMerchantId());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setTimestamp(new Date());
        transactionRepository.save(transaction);
        System.out.println("Sending request to Shaparak: " + request);

        Object responseObj = rabbitTemplate.convertSendAndReceive("psp-queue", request);
        System.out.println("🟢 پاسخ دریافتی از شاپرک: " + responseObj);

        if (responseObj == null) {
            transaction.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("پاسخی از شاپرک دریافت نشد.");
        }

        if (!(responseObj instanceof TransactionResponse)) {
            transaction.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("نوع پاسخ دریافتی نامعتبر است.");
        }

        TransactionResponse response = (TransactionResponse) responseObj;

        // به‌روزرسانی وضعیت تراکنش در دیتابیس
        transaction.setStatus(response.getStatus());
        transactionRepository.save(transaction);

        return response;
    }




    public RemainingResponse remaining (RemainingRequest request){
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setCardNumber(request.getCardNumber());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setTimestamp(new Date());
        System.out.println("Sending request to Shaparak: " + request);

        Object responseObj = rabbitTemplate.convertSendAndReceive("remaining-queue", request);

        if (responseObj == null) {
            transaction.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("پاسخی از شاپرک دریافت نشد.");
        }

        if (!(responseObj instanceof RemainingResponse)) {
            transaction.setStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("نوع پاسخ دریافتی نامعتبر است.");
        }

        RemainingResponse response = (RemainingResponse) responseObj;

        transaction.setStatus(response.getStatus());
        transactionRepository.save(transaction);

        return response;
    }
}