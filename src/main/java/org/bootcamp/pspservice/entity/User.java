package org.bootcamp.pspservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @jakarta.persistence.Id
    @Id
    private String id;
    private String username;
    private String password;
    private String role;
}

