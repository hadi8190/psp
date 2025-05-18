package org.bootcamp.pspservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.pspservice.entity.TransactionRequest;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransactionResponseDTO {
    private UUID transactionId;
    private String cardNumber;
    private int amount;
    private String message;
    private TransactionRequest transactionRequest;

}
