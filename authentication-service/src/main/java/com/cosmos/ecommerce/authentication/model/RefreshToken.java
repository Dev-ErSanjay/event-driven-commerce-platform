package com.cosmos.ecommerce.authentication.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {

    private String id;
    private String token;
    private String userId;
    private LocalDateTime expiryDate;
}