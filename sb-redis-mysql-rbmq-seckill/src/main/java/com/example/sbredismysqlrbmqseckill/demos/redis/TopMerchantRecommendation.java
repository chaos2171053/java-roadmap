package com.example.sbredismysqlrbmqseckill.demos.redis;

import java.util.PriorityQueue;

public class TopMerchantRecommendation {
    // 商家类，包括商家ID和权值
    static class Merchant {
        int id;
        int weight;

        public Merchant(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        // 模拟数据：10000个商家的权值
        int[] weights = new int[10000];
        for (int i = 0; i < 10000; i++) {
            weights[i] = (int) (Math.random() * 100); // 随机生成权值
        }

        // 推荐的商家数量
        int recommendCount = 50;

        // 使用最小堆来存储推荐的商家
        PriorityQueue<Merchant> minHeap = new PriorityQueue<>((m1, m2) -> m1.weight - m2.weight);

        // 初始推荐
        for (int i = 0; i < recommendCount; i++) {
            minHeap.offer(new Merchant(i, weights[i]));
        }

        // 更新推荐，假设更新权值为前一天的2倍
        for (int i = recommendCount; i < 10000; i++) {
            Merchant merchant = new Merchant(i, weights[i] * 2);
            // 如果新商家的权值大于最小堆顶部商家的权值，则将顶部商家替换为新商家
            if (merchant.weight > minHeap.peek().weight) {
                minHeap.poll(); // 弹出堆顶商家
                minHeap.offer(merchant); // 将新商家加入堆
            }
        }

        // 打印推荐的商家
        System.out.println("Recommended merchants:");
        while (!minHeap.isEmpty()) {
            Merchant merchant = minHeap.poll();
            System.out.println("Merchant ID: " + merchant.id + ", Weight: " + merchant.weight);
        }
    }
}
