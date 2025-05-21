package org.bootcamp.shaparakservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.pspservice.enums.TransactionStatus;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {
    private String cardNumber;
    @JsonProperty("remainingBalance")
    private BigDecimal balance;
    private TransactionStatus status;
    private String message;

}
