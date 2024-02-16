package com.example.sbredismysqlrbmqseckill.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stock implements Serializable {
    private static final long serialVersionUID = 8278833061297572121L;
    private Integer id;
    private String name;
    private Integer stock;
}
