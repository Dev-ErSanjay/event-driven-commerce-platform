package com.cosmos.ecommerce.authentication.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;
}