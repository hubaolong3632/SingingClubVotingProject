package com.example.singingclubvotingproject.controller;


import com.example.singingclubvotingproject.idao.ILoginDao;
import com.example.singingclubvotingproject.idao.ISongDao;
import com.example.singingclubvotingproject.model.*;
import com.example.singingclubvotingproject.server.SongServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utio.UtioCode.Result;
import utio.UtioCode.ResultCode;
import utio.UtioY;
import utio.model.JWTModel;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/song")
@CrossOrigin //允许跨域
public class SongController {

    @Resource
    public ISongDao iSongDao;

    @Resource
    public SongServer songServer;


//    投票
    @RequestMapping(value = "/add")
    public Result userStart(@RequestHeader("Authorization") String jwt,UserVoteModel userVoteModel) { //投票分数和投票人名字
        String nickname = UtioY.JWT_PAnalysis(jwt).getJwtmodel().getNickname();
        if(userVoteModel.getGrade()>10){
            return Result.success("成绩应小于10分");
        }
        System.out.println(nickname+"投票分数:"+userVoteModel.getGrade());

        userVoteModel.setName(nickname); //设置投票人姓名
        Boolean aBoolean = songServer.addVote(userVoteModel);
        if(aBoolean==true){
            return  Result.success("投票成功!");
        }
        return Result.failure(ResultCode.No_SUCCESS,"投票失败");
    }



    //  查看个人投票和控制是否跳转
    @RequestMapping(value = "/timerFrom")
    public Result timerFrom(@RequestHeader("Authorization") String jwt){

        String nickname = UtioY.JWT_PAnalysis(jwt).getJwtmodel().getNickname();
        OperateModel operateModel = songServer.timerFrom(nickname);//查看当前个人数据


        return Result.success(operateModel);
    }





    //  插入总分 保存数据
    @RequestMapping(value = "/insert_voteSum")
    public Result insert_voteSum(VoteSumModel vote){
        System.out.println("插入总分");
        vote.setDate(UtioY.Date_getDate());
        Integer integer = iSongDao.insert_voteSum(vote);
        if(integer!=-1){
            return Result.success("插入总分成功");
        }else {
            return Result.success("插入总分失败");
        }

    }






    //    查询所有节目
    @RequestMapping(value = "/from")
    public Result from(){
//        System.out.println("查询所有节目");
        return Result.success(songServer.getSongModels());
    }





}
