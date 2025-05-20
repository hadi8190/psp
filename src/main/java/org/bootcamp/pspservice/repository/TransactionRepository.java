package org.bootcamp.pspservice.repository;

import org.bootcamp.pspservice.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TransactionRepository extends MongoRepository<Transaction, UUID> {
}
