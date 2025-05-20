package org.bootcamp.pspservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.pspservice.enums.TransactionStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {
    private String cardNumber;
    private long remainingBalance;
    private TransactionStatus status;
}
