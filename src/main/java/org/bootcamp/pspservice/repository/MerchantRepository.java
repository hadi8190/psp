package org.bootcamp.pspservice.repository;

import org.bootcamp.pspservice.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MerchantRepository extends MongoRepository<Merchant, String> {

}