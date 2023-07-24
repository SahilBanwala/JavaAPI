package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Student {
    public int RollNo;
    public String Name;

    public Student(int RollNo){
        this.RollNo=RollNo;
    }
}
