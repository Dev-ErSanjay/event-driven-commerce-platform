package com.cosmos.ecommerce.authentication.service;

import com.cosmos.ecommerce.authentication.dto.*;

public interface AuthService {

    AuthResponse register(
            RegisterRequest request);

    AuthResponse login(
            LoginRequest request);

}