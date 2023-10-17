package com.example.singingclubvotingproject.model;

import lombok.Data;

//评委投票
@Data
public class UserVoteModel {
    private Integer id;
    private String name;
    private Integer song;
    private Double grade;
    private String date;
}
