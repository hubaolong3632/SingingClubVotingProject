package com.example.singingclubvotingproject.model;

import lombok.Data;

@Data
public class UserModel {
    public Integer id;
    public String name;//姓名
    public String password;// 密码
    public String jurisdiction; //权限
}
