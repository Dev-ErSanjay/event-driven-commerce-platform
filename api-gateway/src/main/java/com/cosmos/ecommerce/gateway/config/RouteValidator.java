package com.cosmos.ecommerce.gateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    private static final List<String> OPEN_ENDPOINTS = List.of("/auth/register", "/auth/login");

    public Predicate<ServerHttpRequest> isSecured = request -> OPEN_ENDPOINTS
            .stream()
            .noneMatch(uri -> request.getURI()
                    .getPath()
                    .contains(uri));
}