package com.cosmos.ecommerce.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cosmos.ecommerce.product.dto.*;
import com.cosmos.ecommerce.product.mapper.ProductMapper;
import com.cosmos.ecommerce.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl
        implements ProductService {

    private final ProductRepository repository;

    public ProductResponse create(
            ProductRequest request) {

        var product = ProductMapper.toEntity(request);

        repository.save(product);

        return ProductMapper.toResponse(product);
    }

    public ProductResponse get(String id) {

        return ProductMapper.toResponse(
                repository.findById(id));
    }

    public void delete(String id) {

        repository.delete(id);
    }
}