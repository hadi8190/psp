package org.bootcamp.pspservice.entity;

import lombok.*;
import org.bootcamp.pspservice.enums.TransactionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document("transactions")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class TransactionDocument implements Serializable {
    @Id
    private UUID id;
    private String cardNumber;
    private int amount;
    private String merchantId;
    private TransactionStatus status;

}
