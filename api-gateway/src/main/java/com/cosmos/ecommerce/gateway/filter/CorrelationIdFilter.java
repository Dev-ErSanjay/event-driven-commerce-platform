package com.cosmos.ecommerce.gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CorrelationIdFilter {

    private static final String HEADER = "X-Correlation-ID";

    @Bean
    public GlobalFilter correlationFilter() {

        return (exchange, chain) -> {
            String correlationId = UUID.randomUUID()
                    .toString();

            var request = exchange
                    .getRequest()
                    .mutate()
                    .header(HEADER, correlationId)
                    .build();

            return chain.filter(exchange
                    .mutate()
                    .request(request)
                    .build());
        };
    }
}