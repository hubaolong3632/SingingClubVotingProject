package com.example.singingclubvotingproject.model;

import java.util.ArrayList;
import java.util.List;

public class StudentListModel {
   private List<StudentModel> studentModelList=new ArrayList<>();

    public List<StudentModel> getStudent() {
        return studentModelList;
    }

    public void setStudent(StudentModel student) {
        studentModelList.add(student);
    }
}
