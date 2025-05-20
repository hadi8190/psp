package org.bootcamp.pspservice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // هندل کردن خطاهای اعتبارسنجی (مثلا @Valid)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), "مقدار وارد شده در فیلد '" + error.getField() + "' معتبر نیست.");
        }
        return ResponseEntity.badRequest().body(errors);
    }

    // هندل کردن استثناهای عمومی
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("خطا", "مشکلی در پردازش درخواست رخ داده است. لطفا دوباره تلاش کنید.");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


    @ExceptionHandler(MerchantNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMerchantNotFoundException(MerchantNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("خطا", ex.getMessage() != null ? ex.getMessage() : "پذیرنده مورد نظر یافت نشد.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
