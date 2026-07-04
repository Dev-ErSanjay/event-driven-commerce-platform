package com.cosmos.ecommerce.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private String productId;
    private String name;
    private Double price;
    private Integer stock;
    private String imageUrl;
}