package com.cosmos.ecommerce.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.create();
    }

    @Bean
    public DynamoDbEnhancedClient enhancedClient(
            DynamoDbClient client) {

        return DynamoDbEnhancedClient
                .builder()
                .dynamoDbClient(client)
                .build();
    }
}