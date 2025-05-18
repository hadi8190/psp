package org.bootcamp.pspservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.pspservice.enums.TransactionStatus;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionMessage implements Serializable {

    private String cardNumber;
    private int amount;
    private String merchantId;
    private TransactionStatus status;
}
