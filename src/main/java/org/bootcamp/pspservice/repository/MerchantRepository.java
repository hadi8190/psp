package org.bootcamp.pspservice.repository;

import jakarta.validation.constraints.NotBlank;
import org.bootcamp.pspservice.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;
import java.util.UUID;

public interface MerchantRepository extends MongoRepository<Merchant, UUID> {
    Optional<Object> findMerchantsBy(@NotBlank(message = "شناسه پذیرنده نمی‌تواند خالی باشد.") String merchantId);

}