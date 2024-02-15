package com.example.springbootredisratelimiting.anotation;

import com.example.springbootredisratelimiting.constant.Constants;
import com.example.springbootredisratelimiting.enums.LimitType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    // 定义了一个名为 key 的成员变量，其类型为 String，并且默认值为 Constants.RATE_LIMIT_KEY
    String key() default Constants.RATE_LIMIT_KEY;
    // 限流时间
    int time() default 60;

    // 限流次数
    int count() default 5;

    // 限流类型
    LimitType limitType() default LimitType.DEFAULT;

    // 限流后返回的文字
    String limitMsg() default "Too many requests, please try again later.";



}
