package com.example.designpattern.factory.method;

public class AoDiFactory implements CarFactory {
    public Car createCar() {
        return new AoDi();
    }
}