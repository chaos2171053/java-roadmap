package com.javadoubts.demos.web.aspec;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {

    @Before("execution(* com.javadoubts..*(..))")
    public void beforeAdvice() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.javadoubts..*(..))")
    public void afterAdvice() {
        System.out.println("After method execution");
    }

    @AfterReturning(pointcut = "execution(* com.javadoubts..*(..))", returning = "result")
    public void afterReturningAdvice(Object result) {
        System.out.println("After returning method execution with result: " + result);
    }

    @Around("execution(* com.javadoubts..*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method execution in around advice");
        Object result = joinPoint.proceed(); // 执行目标方法
        System.out.println("After method execution in around advice");
        return result;
    }
}
