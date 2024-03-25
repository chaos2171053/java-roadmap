package com.example.designpattern.factory.simple;

public class Client01 {
    public static void main(String[] args) {
        Car aodi =CarFactory.createCar("奥迪");
        Car bmw =CarFactory.createCar("宝马");
        aodi.run();
        bmw.run();
    }
}
