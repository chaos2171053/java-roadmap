package com.example.designpattern.strategy;

public class Context {
    PayStrategy strategy;
    public Context(PayStrategy strategy) {
        this.strategy = strategy;
    }
    public void algorithmInterface() {
        strategy.algorithmInterface();
    }
}
