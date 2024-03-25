package com.example.designpattern.factory.method;

public class BmwFactory implements CarFactory {
    public Car createCar() {
        return new Bmw();
    }
}