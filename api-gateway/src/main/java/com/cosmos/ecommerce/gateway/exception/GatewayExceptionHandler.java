package com.cosmos.ecommerce.gateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
@Slf4j
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(
            ServerWebExchange exchange,
            Throwable ex) {

        log.error("Gateway Error : ", ex);

        exchange
                .getResponse()
                .setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        return exchange
                .getResponse()
                .setComplete();
    }
}