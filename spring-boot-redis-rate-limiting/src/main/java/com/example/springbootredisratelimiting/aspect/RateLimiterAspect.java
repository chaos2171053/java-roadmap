package com.example.springbootredisratelimiting.aspect;

import com.example.springbootredisratelimiting.anotation.RateLimiter;
import com.example.springbootredisratelimiting.enums.LimitType;
import com.example.springbootredisratelimiting.utils.IPUtils;
import com.example.springbootredisratelimiting.utils.RedisUtils;
import com.example.springbootredisratelimiting.utils.ServletUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RateLimiterAspect {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 获取限流的 key
     * @param point
     * @param rateLimiter
     * @return
     */
    public String getCombineKey(JoinPoint point, RateLimiter rateLimiter){
        StringBuffer stringBuffer = new StringBuffer(rateLimiter.key());
        if(rateLimiter.limitType()== LimitType.IP){
            System.out.println("get ip getCombineKey");
            //stringBuffer.append(IPUtils.getIPAddr(ServletUtils.getRequest())).append("-");
            stringBuffer.append(IPUtils.getIPAddr(ServletUtils.getRequest()));
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        //stringBuffer.append(targetClass.getName()).append("-").append(method.getName());
        return stringBuffer.toString();
    }
    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) {
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        String key =  getCombineKey(point,rateLimiter);
        System.out.println("getCombineKey "+key);
        long total = redisUtils.incr(key,1);
        if (total == 1) {
            redisUtils.expire(key, time);
        }
        if (total > count) {
            throw new RuntimeException(rateLimiter.limitMsg());
        }
    }
}
