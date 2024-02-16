package com.example.sbredismysqlrbmqseckill.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -7490333580527047637L;
    // 在序列化和反序列化过程中，Java 序列化系统会根据 serialVersionUID 来确定类的版本，
    // 如果版本一致，就可以正常进行序列化和反序列化操作，即使类的结构发生了变化也不会出现版本不一致的问题。
    private Integer id;
    private String orderName;
    private Integer orderUser;
}
