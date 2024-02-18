package com.example.sbredismysqlrbmqseckill;

import com.example.sbredismysqlrbmqseckill.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbRedisMysqlRbmqSeckillApplication implements ApplicationRunner {
    private final RedisService redisService;

    @Autowired
    public SbRedisMysqlRbmqSeckillApplication(RedisService redisService) {
        this.redisService = redisService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbRedisMysqlRbmqSeckillApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments applicationArguments) {
        // 在 redis 中给 Q弹豆干 添加10个库存
        redisService.put("Q弹豆干", 10, 20);
    }
}
