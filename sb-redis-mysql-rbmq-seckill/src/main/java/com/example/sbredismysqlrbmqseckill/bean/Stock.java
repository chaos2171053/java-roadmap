package com.example.sbredismysqlrbmqseckill.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stock implements Serializable {
    private static final long serialVersionUID = 7667526025487637L;
    private Integer id;
    private String name;
    private Integer stock;
    private Integer version; // 添加版本号字段
}
