package com.example.singingclubvotingproject.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//用户状态
//@Data
public class USerStateModel {
    private String name;//用户姓名
    private String jurisdiction;//用户权限
    private Boolean state ;//在线状态
    private Date date ;//上一次在线时间
    private List<SongModel> songModel; //评委单
//    private VoteSumModel vote; //投票


//    public VoteSumModel getVote() {
//        return vote;
//    }
//
//    public void setVote(VoteSumModel vote) {
//        this.vote = vote;
//    }

    //    判断当前歌单是否有已经投票
    public Boolean songVote(Integer id){
        return songModel.equals(id);
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SongModel> getSongModel() {
        return songModel;
    }

    public void setSongModel(List<SongModel> songModel) {
        this.songModel = songModel;
    }

    @Override
    public String toString() {
        return "USerStateModel{" +
                "name='" + name + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", songModel=" + songModel +
                '}';
    }
}
