package com.example.sbredismysqlrbmqseckill.bean;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MessageSend  implements Serializable {

    private static final long serialVersionUID = 3086168628208292609L;
    private Integer id;
    private Integer username;
    private String stockName;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
