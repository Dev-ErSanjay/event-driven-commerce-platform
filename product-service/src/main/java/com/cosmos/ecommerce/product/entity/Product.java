package com.cosmos.ecommerce.product.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class Product {

    private String productId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
    private String imageUrl;

    @DynamoDbPartitionKey
    public String getProductId() {
        return productId;
    }
}