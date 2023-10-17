package com.example.singingclubvotingproject.controller;

import com.example.singingclubvotingproject.idao.ISongDao;
import com.example.singingclubvotingproject.model.UserVoteModel;
import com.example.singingclubvotingproject.server.SongServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utio.UtioCode.Result;
import utio.UtioY;

import javax.annotation.Resource;

//后台管理接口
@RestController
@CrossOrigin //允许跨域
@RequestMapping(value = "/backstage")
public class BackstageController {
    @Resource
    public ISongDao iSongDao;

    @Resource
    public SongServer songServer;


    //    发起投票
    @RequestMapping(value = "/initLateVote")
    public Result initLateVote(Integer begin, Integer end) {

        songServer.initLateVote(begin, end);
      return Result.success("发起投票成功");
    }

}
