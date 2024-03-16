package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void testPurchaseProduct() throws Exception {
        int numThreads = 10; // 模拟并发线程数量
        int quantity = 5; // 每个线程购买的数量
        Long productId = 1L; // 商品ID

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        List<Callable<ResponseEntity<String>>> tasks = new ArrayList<>();

        // 创建并发线程
        for (int i = 0; i < numThreads; i++) {
            tasks.add(() -> restTemplate.postForEntity("http://localhost:" + port + "/products?productId=" + productId + "&quantity=" + quantity, null, String.class));
        }

        // 执行并发请求
        List<Future<ResponseEntity<String>>> futures = executorService.invokeAll(tasks);

        // 验证响应
        for (Future<ResponseEntity<String>> future : futures) {
            ResponseEntity<String> responseEntity = future.get();
            assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(responseEntity.getBody()).isEqualTo("Purchase successful!");
        }

        // 检查库存是否为负数等其他逻辑
    }
}