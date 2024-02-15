package com.example.springbootredisratelimiting.controller;

import com.example.springbootredisratelimiting.anotation.RateLimiter;
import com.example.springbootredisratelimiting.enums.LimitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

//在redis 记录用户的访问次数，每访问一次就增加数量，设置缓存的时间为1分钟，1分钟内访问次数达到5次即限制访问
@RestController
public class RateLimitController {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RateLimitController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/visit")
    public ResponseEntity<String> visit() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String key = "user:visit:count";
        // 使用 increment 方法可以原子性地完成增加操作，并返回增加后的值。
        // 无需在每次访问时都进行取出数据和设置数据的操作，减少了不必要的操作，提高了性能。
        Long count = ops.increment(key, 1);
        if (count == null || count == 1) {
            redisTemplate.expire(key, Duration.ofMinutes(1));
        }
        if (count != null && count > 5) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Access limit exceeded");
        }
        return ResponseEntity.ok("Visit count: " + count);
    }

    @GetMapping("/annotation/visit")
    @RateLimiter(time = 60,count = 5,limitType = LimitType.IP,limitMsg = "一分钟内只能请求5次，请稍后重试")
    public  ResponseEntity<String> annotationVisit(){
        return ResponseEntity.ok("Hello ok~");
    }


}
