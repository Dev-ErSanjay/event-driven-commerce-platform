package com.cosmos.ecommerce.product.mapper;

import com.cosmos.ecommerce.product.dto.*;
import com.cosmos.ecommerce.product.entity.Product;

import java.util.UUID;

public class ProductMapper {

    public static Product toEntity(
            ProductRequest request) {

        return Product.builder()
                .productId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .category(request.getCategory())
                .build();
    }

    public static ProductResponse toResponse(
            Product product) {

        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .build();
    }
}