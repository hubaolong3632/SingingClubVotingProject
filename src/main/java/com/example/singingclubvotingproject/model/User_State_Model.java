package com.example.singingclubvotingproject.model;

import lombok.Data;

@Data
public class User_State_Model {
    private String name;//用户姓名
    private Boolean state ;//在线状态
    private  Boolean aBoolean=false;//歌曲打分
    private  Double grade=0.0; ;//评委评论分
}
