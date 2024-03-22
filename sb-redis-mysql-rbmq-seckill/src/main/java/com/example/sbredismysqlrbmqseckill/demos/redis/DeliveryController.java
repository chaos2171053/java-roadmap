package com.example.sbredismysqlrbmqseckill.demos.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/simulate-delivery")
    public String simulateDelivery() {
        deliveryService.simulateDelivery();
        return "Delivery simulation started";
    }
}

