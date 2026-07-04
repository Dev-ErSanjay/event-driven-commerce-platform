package com.cosmos.ecommerce.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.cosmos.ecommerce.product.dto.*;
import com.cosmos.ecommerce.product.service.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody ProductRequest request) {

        return service.create(request);
    }

    @GetMapping("/{id}")
    public ProductResponse get(
            @PathVariable String id) {

        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable String id) {

        service.delete(id);
    }
}