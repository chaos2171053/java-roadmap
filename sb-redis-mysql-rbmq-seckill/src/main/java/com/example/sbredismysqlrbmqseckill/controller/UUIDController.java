package com.example.sbredismysqlrbmqseckill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UUIDController {

    @GetMapping("/generateUUID")
    public String generateUUID() {
        return String.valueOf(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
