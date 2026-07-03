package com.cosmos.ecommerce.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoggingFilter {

    @Bean
    public GlobalFilter globalFilter() {

        return (exchange, chain) -> {

            String path = exchange.getRequest()
                    .getPath()
                    .toString();

            log.info(
                    "Incoming Request : {}",
                    path);

            return chain.filter(exchange);
        };
    }
}