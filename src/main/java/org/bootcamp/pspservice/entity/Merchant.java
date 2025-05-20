package org.bootcamp.pspservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "merchants")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Merchant {
    @Id
    private UUID id;
    private String name;
}