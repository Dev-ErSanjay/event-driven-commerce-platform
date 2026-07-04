package com.cosmos.ecommerce.product.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    private String description;

    @Positive
    private Double price;

    private Integer stock;

    private String category;
}