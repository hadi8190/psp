package org.bootcamp.pspservice.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RemainingRequest {
    @NotBlank(message = "شماره کارت نمی‌تواند خالی باشد.")
    @Pattern(regexp = "\\d{16}", message = "شماره کارت باید 16 رقم عددی باشد.")
    private String cardNumber;
}
