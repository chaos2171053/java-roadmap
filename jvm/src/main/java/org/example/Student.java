package org.example;

import lombok.Data;

@Data
public class Student {
    String name;
    public Student(String name){
        this.name = name;
    }
}

