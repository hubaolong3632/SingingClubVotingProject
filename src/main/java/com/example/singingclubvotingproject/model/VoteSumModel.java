package com.example.singingclubvotingproject.model;

import lombok.Data;

@Data
public class VoteSumModel {
    private String songlist; //投票的节目名称
    private Double user_grade;//群众投分
    private Double leadership_grade; //领导投分
    private Double judge_grade; //评委投分
    private Double grade;//一共分数
    private String date;//当前时间
}
