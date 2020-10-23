package com.example.microservice.organizationservice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
class OrganizationServiceApplicationTests {

    @Disabled
	@Test
	void contextLoads1() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 10000; ++i) {
            try {
                restTemplate.exchange("http://localhost:8082/v1/organizations/e254f8c-c442-4ebe-a82a-e2fc1d1ff78a/licenses/f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a/rest", HttpMethod.GET,null,Void.class);
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
    @Disabled
	@Test
	void contextLoads2() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 50, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        for (int i = 0; i < 10000; ++i) {
            executor.execute(() -> {
                try {
                    restTemplate.exchange("http://localhost:8082/v1/organizations/e254f8c-c442-4ebe-a82a-e2fc1d1ff78a/licenses", HttpMethod.GET,null,Void.class);
                    Thread.sleep(10);
                } catch (Exception e) {}
            });
        }

        try {
            executor.shutdown();
            while (true) {
                if (executor.awaitTermination(10, TimeUnit.MINUTES)) {
                    break;
                }
            }
        } catch (InterruptedException ignored) {}
    }

}
