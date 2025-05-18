package org.bootcamp.pspservice.repository;

import org.bootcamp.pspservice.entity.TransactionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<TransactionDocument, String> {}
