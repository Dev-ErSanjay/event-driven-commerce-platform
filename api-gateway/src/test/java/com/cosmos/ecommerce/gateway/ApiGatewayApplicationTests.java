package com.cosmos.ecommerce.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"jwt.secret=my-super-secret-key-for-commerce-platform"
})
class ApiGatewayApplicationTests {

	@Test
	void contextLoads() {
	}

}