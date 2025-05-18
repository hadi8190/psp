package org.bootcamp.pspservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document("merchants")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Merchant implements Serializable {
    @Id
    private String id;
    private String name;
}
