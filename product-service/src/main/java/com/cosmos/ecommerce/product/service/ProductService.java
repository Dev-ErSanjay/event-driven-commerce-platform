package com.cosmos.ecommerce.product.service;

import com.cosmos.ecommerce.product.dto.*;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse get(String id);

    void delete(String id);
}