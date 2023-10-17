package com.example.singingclubvotingproject.idao;

import com.example.singingclubvotingproject.model.SongModel;
import com.example.singingclubvotingproject.model.UserModel;
import com.example.singingclubvotingproject.model.UserVoteModel;
import com.example.singingclubvotingproject.model.VoteSumModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ISongDao {
//        查询所有节目单
        public List<SongModel> from_songList();

//        插入一条领导投票
        public Integer insert_userVote(@Param("user") UserVoteModel user);
//        插入一条总分
        public Integer insert_voteSum(@Param("vote") VoteSumModel vote);
}
