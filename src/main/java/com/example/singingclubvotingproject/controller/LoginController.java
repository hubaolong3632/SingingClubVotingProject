package com.example.singingclubvotingproject.controller;


import com.example.singingclubvotingproject.idao.ILoginDao;
import com.example.singingclubvotingproject.model.USerStateModel;
import com.example.singingclubvotingproject.model.UserModel;
import com.example.singingclubvotingproject.server.SongServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import utio.UtioCode.Result;
import utio.UtioCode.ResultCode;
import utio.UtioY;
import utio.model.JWTModel;

import javax.annotation.Resource;
import java.util.Map;
@CrossOrigin //允许跨域
@RestController
@RequestMapping(value = "/login",method = RequestMethod.POST)
public class LoginController {

    @Resource
    public ILoginDao loginDao;

    @Resource
    public SongServer songServer;

//
//    @Resource
//    public Map<String, USerStateModel> userStart;


//    查询所有用户投票状态
    @RequestMapping(value = "/userStart")
    public Result userStart(){
        return Result.success(songServer.userStart());
    }


    @RequestMapping(value = "/cs")
    public Result cs(@RequestHeader("Authorization") String jwt){
        System.out.println(UtioY.JWT_PAnalysis(jwt).getJwtmodel());
        return Result.success(UtioY.JWT_PAnalysis(jwt).getJwtmodel());
    }


    @RequestMapping(value = "/login")
    public Result login(String name,String password){
        System.out.println(name+"尝试登入");

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setPassword(password);
        UserModel login = loginDao.login(userModel);
        System.out.println(login);
        if(login==null){
            return  Result.failure(ResultCode.No_SUCCESS,"用户名密码不正确");
        }
        JWTModel jwtModel = new JWTModel();
        jwtModel.setType(login.getJurisdiction()); //权限
        jwtModel.setNickname(login.getName()); //评委姓名
        jwtModel.setUid(login.getId());//评委id
        String jwt = UtioY.JWT_Create(login.getName(), jwtModel);

        return Result.success(jwt);
    }



}
