package com.example.singingclubvotingproject.model;

import lombok.Data;

import java.util.Objects;

//@Data
public class SongModel {
   private  Integer id;//歌曲id
   private  String name; //歌曲名称
   private  Boolean aBoolean=false;//歌曲打分
   private  Double grade=0.0; ;//评委评论分



    public SongModel() {
    }

    public SongModel(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongModel songModel = (SongModel) o;
        return Objects.equals(id, songModel.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
