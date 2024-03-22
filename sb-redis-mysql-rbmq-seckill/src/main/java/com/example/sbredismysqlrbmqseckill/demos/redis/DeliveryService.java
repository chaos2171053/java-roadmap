package com.example.sbredismysqlrbmqseckill.demos.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 情景题：如果一个外卖配送单子要发布，现在有200个骑手都想要接这一单，如何保证只有一个骑手
//接到单子？
//这个可以用redis的lpush rpop来实现。
@Service
public class DeliveryService {
    private static final String DELIVERY_QUEUE_KEY = "delivery_queue";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void simulateDelivery() {
        // 获取List类型操作对象
        ListOperations<String, String> listOps = redisTemplate.opsForList();

        // 清空队列，用于演示
        listOps.getOperations().delete(DELIVERY_QUEUE_KEY);

        // 模拟有200个骑手想要接单
        for (int i = 1; i <= 200; i++) {
            String deliveryMan = "DeliveryMan" + i;
            listOps.leftPush(DELIVERY_QUEUE_KEY, deliveryMan);
            System.out.println(deliveryMan + " 加入配送队列");
        }

        // 只有一个骑手能够接到单子
        String deliveryMan = listOps.rightPop(DELIVERY_QUEUE_KEY);
        System.out.println(deliveryMan + " 成功接收配送单");
    }
}

