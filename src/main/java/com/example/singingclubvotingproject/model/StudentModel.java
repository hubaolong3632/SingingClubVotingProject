package com.example.singingclubvotingproject.model;

import lombok.Data;

@Data

public class StudentModel {
    private String name;//姓名和学号
    private String grade;//班级
    private String department;//系部

    public StudentModel() {
    }

    public StudentModel( String name, String grade, String department) {
        this.name = name;
        this.grade = grade;
        this.department = department;
    }
}
