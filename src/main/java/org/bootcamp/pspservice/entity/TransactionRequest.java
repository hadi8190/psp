package org.bootcamp.pspservice.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {
    @NotBlank(message = "شماره کارت نمی‌تواند خالی باشد.")
    @Pattern(regexp = "\\d{16}", message = "شماره کارت باید 16 رقم عددی باشد.")
    private String cardNumber;

    @Min(value = 1001, message = "مبلغ باید بیشتر از 1000 تومان باشد.")
    private long amount;

    @NotBlank(message = "شناسه پذیرنده نمی‌تواند خالی باشد.")
    private String merchantId;
}
