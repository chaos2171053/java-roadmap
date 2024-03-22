package com.example.sbredismysqlrbmqseckill.demos.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueExample queueExample;

    @GetMapping("/process-task")
    public String processTask() {
        queueExample.processTask();
        return "Processing task...";
    }
}

