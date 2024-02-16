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
        redisService.put("watch", 10000, 20);
    }
}
