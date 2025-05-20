package org.bootcamp.pspservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.pspservice.enums.TransactionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    private UUID id;
    private String cardNumber;
    private long amount;
    private String merchantId;
    private TransactionStatus status;
    private Date timestamp;
}
