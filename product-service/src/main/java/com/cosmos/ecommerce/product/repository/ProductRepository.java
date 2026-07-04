package com.cosmos.ecommerce.product.repository;

import com.cosmos.ecommerce.product.entity.Product;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;

@Repository
public class ProductRepository {

    private final DynamoDbTable<Product> table;

    public ProductRepository(
            DynamoDbEnhancedClient client) {

        table = client.table(
                "products",
                TableSchema.fromBean(Product.class));
    }

    public void save(Product product) {

        table.putItem(product);
    }

    public Product findById(String id) {

        return table.getItem(
                r -> r.key(
                        k -> k.partitionValue(id)));
    }

    public void delete(String id) {

        table.deleteItem(
                r -> r.key(
                        k -> k.partitionValue(id)));
    }
}