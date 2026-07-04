package com.cosmos.ecommerce.authentication.service.impl;

import com.cosmos.ecommerce.authentication.dto.*;
import com.cosmos.ecommerce.authentication.model.User;
import com.cosmos.ecommerce.authentication.repository.UserRepository;
import com.cosmos.ecommerce.authentication.security.JwtService;
import com.cosmos.ecommerce.authentication.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .email(request.getEmail())
                .password(
                        encoder.encode(request.getPassword()))
                .role("USER")
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(user);

        return AuthResponse.builder()
                .accessToken(
                        jwtService.generateToken(user.getEmail()))
                .refreshToken(UUID.randomUUID().toString())
                .build();

    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        if (!encoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        return AuthResponse.builder()
                .accessToken(
                        jwtService.generateToken(user.getEmail()))
                .refreshToken(UUID.randomUUID().toString())
                .build();
    }
}