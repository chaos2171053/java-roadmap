package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 定义一个接口
interface MyInterface {
    void sayHello();
}

// 实现接口的类
class MyClass implements MyInterface {
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

// 定义一个动态代理处理器
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoking sayHello()");
        Object result = method.invoke(target, args);
        System.out.println("After invoking sayHello()");
        return result;
    }
    public static void main(String[] args) {
        // 创建一个原始对象
        MyInterface myObject = new MyClass();

        // 创建一个动态代理对象
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyInvocationHandler(myObject)
        );

        // 调用代理对象的方法
        proxy.sayHello();
    }
}


