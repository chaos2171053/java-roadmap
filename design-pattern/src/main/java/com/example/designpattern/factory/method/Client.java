package com.example.designpattern.factory.method;

public class Client {
    public static void main(String[] args) {
        Car aodi = new AoDiFactory().createCar();
        Car jili = new BmwFactory().createCar();
        aodi.run();
        jili.run();
    }
}
