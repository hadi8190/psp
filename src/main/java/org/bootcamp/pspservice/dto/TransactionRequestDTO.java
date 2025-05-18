package org.bootcamp.pspservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcamp.pspservice.enums.TransactionStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransactionRequestDTO {
    @NotBlank(message = "شماره کارت نباید خالی باشد.")
    @Pattern(regexp = "\\d{16}", message = "شماره کارت باید ۱۶ رقمی باشد.")
    private String cardNumber;

    @Min(value = 1001, message = "مبلغ باید بیشتر از ۱۰۰۰ تومان باشد.")
    private int amount;

    @NotBlank(message = "شناسه پذیرنده نباید خالی باشد.")
    private String merchantId;

    @NotNull(message = "وضعیت تراکنش نمی‌تواند خالی باشد.")
    private TransactionStatus status;

}
