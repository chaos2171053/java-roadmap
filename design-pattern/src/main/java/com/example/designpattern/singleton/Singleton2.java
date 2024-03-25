package com.example.designpattern.singleton;

// 双重检查锁
public class Singleton2 {
    // volatile 一是保证此变量对于所有线程的可见性。
    //即当一条线程修改了这个变量的值，新值对于其他线程来说是可以立即得知的。
    //二是禁止指令重排序优化。
    private volatile static Singleton2 instance; //①
    private Singleton2() { //②
    }
    public static Singleton2 getInstance() {
        if (instance == null) {//③
            synchronized (Singleton2.class) {
                if (instance == null) {//④
                    instance = new Singleton2();//⑤
                }
            }
        }
        return instance;
    }
}
