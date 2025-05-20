package org.bootcamp.bankservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.pspservice.enums.TransactionStatus;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RemainingResponse {
    private String cardNumber;
    private BigDecimal remainingBalance;
    private TransactionStatus status;
}
