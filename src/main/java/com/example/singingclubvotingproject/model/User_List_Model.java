package com.example.singingclubvotingproject.model;

import lombok.Data;

import java.util.List;

@Data
public class User_List_Model {
    private  VoteSumModel vote;
    private  List<User_State_Model> userList;
}
