package org.example.spring.ioc;

interface Fruit {
    public abstract void eat();
}

class Orange implements Fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

public class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

class Client {
    public static void main(String[] a) {
        Fruit f = Factory.getInstance("org.example.spring.ioc.Apple");
        if (f != null) {
            f.eat();
        }
    }
}
