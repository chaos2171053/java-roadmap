package com.example.designpattern.strategy;

public class PayStrategyA extends PayStrategy {
    public void algorithmInterface() {
        System.out.println("微信支付");
    }
}