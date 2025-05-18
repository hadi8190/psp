package org.bootcamp.pspservice.entity;

import lombok.*;
import org.bootcamp.pspservice.enums.TransactionStatus;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class TransactionRequest implements Serializable {
    private String cardNumber;
    private int amount;
    private String merchantId;
    private TransactionStatus status;

}
