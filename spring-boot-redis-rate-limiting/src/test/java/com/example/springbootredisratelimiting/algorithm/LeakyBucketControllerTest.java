package com.example.springbootredisratelimiting.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LeakyBucketControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("多线程并发测试")
    public void testConcurrentRequests() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 创建一个固定大小为10的线程池
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                String response = restTemplate.getForObject("http://localhost:" + port + "/api/endpoint", String.class);
                // 这里可以添加验证逻辑，确保请求返回的结果是预期的
                System.out.println("port :"+port + " Response : " + response);
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES); // 等待所有任务执行完成
    }

    @RepeatedTest(20)
    @DisplayName("单线程重复测试")
    public void testSingleThreadRequest() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/api/endpoint", String.class);
        // 这里可以添加验证逻辑，确保请求返回的结果是预期的
        System.out.println("Response: " + response);
    }
}
