package com.cosmos.ecommerce.gateway.filter;

import com.cosmos.ecommerce.gateway.config.RouteValidator;
import com.cosmos.ecommerce.gateway.security.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter
        extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    private final RouteValidator validator;
    private final JwtService jwtService;

    public JwtAuthenticationFilter(
            RouteValidator validator,
            JwtService jwtService) {

        super(Config.class);

        this.validator = validator;
        this.jwtService = jwtService;
    }

    public static class Config {

    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            if (validator.isSecured.test(exchange.getRequest())) {

                if (!exchange.getRequest()
                        .getHeaders()
                        .containsKey("Authorization")) {
                    exchange.getResponse()
                            .setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse()
                            .setComplete();
                }

                String token = exchange.getRequest()
                        .getHeaders()
                        .getFirst("Authorization");

                if (token == null || !token.startsWith("Bearer ")) {
                    exchange.getResponse()
                            .setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse()
                            .setComplete();
                }
                token = token.substring(7);
                try {
                    jwtService.validateToken(token);
                } catch (Exception exception) {
                    exchange.getResponse()
                            .setStatusCode(HttpStatus.UNAUTHORIZED);

                    return exchange.getResponse()
                            .setComplete();
                }
            }
            return chain.filter(exchange);
        };
    }
}