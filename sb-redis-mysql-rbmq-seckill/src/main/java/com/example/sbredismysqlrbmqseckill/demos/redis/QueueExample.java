package com.example.sbredismysqlrbmqseckill.demos.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueExample {
    private static final String TASK_QUEUE_KEY = "task_queue";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void processTask() {
        // 将任务添加到队列
        redisTemplate.opsForList().leftPush(TASK_QUEUE_KEY, "task1");
        redisTemplate.opsForList().leftPush(TASK_QUEUE_KEY, "task2");
        redisTemplate.opsForList().leftPush(TASK_QUEUE_KEY, "task3");
        redisTemplate.opsForList().leftPush(TASK_QUEUE_KEY, "task4");
        // 打印队列中的所有任务
        List<String> tasks = redisTemplate.opsForList().range(TASK_QUEUE_KEY, 0, -1);
        System.out.println("Tasks in queue: " + tasks);

        // 从队列中取出任务
        String task = redisTemplate.opsForList().rightPop(TASK_QUEUE_KEY);
        System.out.println("Processing task: " + task);

        tasks = redisTemplate.opsForList().range(TASK_QUEUE_KEY, 0, -1);
        System.out.println("Tasks in queue: " + tasks);
    }
}

