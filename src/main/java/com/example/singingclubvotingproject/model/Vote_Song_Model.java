package com.example.singingclubvotingproject.model;

import lombok.Data;

import java.util.List;

@Data
public class Vote_Song_Model {
    private  VoteSumModel vote;
    private  SongModel songModel;
}
