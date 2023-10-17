package com.example.singingclubvotingproject.controller;


import com.example.singingclubvotingproject.idao.ILoginDao;
import com.example.singingclubvotingproject.idao.ISongDao;
import com.example.singingclubvotingproject.model.*;
import com.example.singingclubvotingproject.server.SongServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import utio.UtioCode.Result;
import utio.UtioCode.ResultCode;
import utio.UtioY;
import utio.model.JWTModel;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@CrossOrigin //允许跨域
@RestController
@RequestMapping(value = "/login",method = RequestMethod.POST)
public class LoginController {

    @Resource
    public ILoginDao loginDao;

    @Resource
    public SongServer songServer;

    @Resource
    public ISongDao iSongDao;

    @RequestMapping(value = "/from_vote")
    public Result userStart(){

        return Result.success(iSongDao.from_vote());
    }


//    查询所有用户投票状态
    @RequestMapping(value = "/userStart")
    public Result userStart(Integer port){ //放入页数拿到他对应的分
        Map<String, USerStateModel> sMap = songServer.userStart();
        Date currentDate = new Date(); //拿到当前时间
        Double lingDao=0.0;
        Double pingWei=0.0;
        Double guanZhon=0.0;
        Double danqian=0.0;
        Double maxGrade=0.0;
        Double minGrade=100.0;
        List<User_State_Model> userList=new ArrayList<>();



        for (String som : sMap.keySet()) {
            USerStateModel user = sMap.get(som);
            User_State_Model user_state_model = new User_State_Model();
            for(SongModel k:user.getSongModel()){ //查找比较评委 便利每一个评委
                if(k.getId()==port){

                    Double grade =k.getGrade();

                    if(grade==0){ //如果评分为0的话默认先给到8分

                        grade=8.0;
                    }
//                    System.out.println(user);
                    user_state_model.setABoolean(k.getaBoolean());
                    user_state_model.setGrade(k.getGrade());
                    user_state_model.setState(user.getState());
                    user_state_model.setName(user.getName());

                    if(user.getJurisdiction().equals("评委")){
                        if(grade<minGrade){ //找到最大
                            minGrade=grade;
                        }
                        if(maxGrade<grade){ //找到最小
                            maxGrade=grade;
                        }

                        pingWei+=grade;
                    }else if(user.getJurisdiction().equals("领导")){

                        lingDao+=grade;
                    }else if(user.getJurisdiction().equals("群众")){
                        guanZhon+=grade;
                    }
                }
            }


            Date date =user.getDate();
            if(date==null){ //如果用户还没有登入
                user.setState(false);
            }else{
                long diffInSeconds = (currentDate.getTime() - date.getTime());//获取两个相差的毫秒数
//                System.out.println("相差的毫秒数"+diffInSeconds);
                if(diffInSeconds>3000){ //如果相差大于三秒
                    user.setState(false); //标识用户离线
//                    System.out.println("用户:"+user.getName()+"离线");
                }else{
                    user.setState(true); //标识用户在线
                }

            }



            userList.add(user_state_model);
        }
        pingWei=pingWei-maxGrade-minGrade; //计算出来他的差
        lingDao = lingDao/2.0; //两个人
        pingWei = pingWei/6.0;//6个人
//        guanZhon=guanZhon;
        danqian=lingDao*0.6+pingWei*0.3+guanZhon*0.1;


        VoteSumModel vote = new VoteSumModel();
        vote.setUser_grade(guanZhon);
        vote.setJudge_grade(pingWei);
        vote.setLeadership_grade(lingDao);
        vote.setGrade(danqian);

        User_List_Model user_list_model = new User_List_Model();
        user_list_model.setUserList(userList);
        user_list_model.setVote(vote);

        return Result.success(user_list_model);
    }






    //    查询用户状态只要成绩
    @RequestMapping(value = "/performance")
    public Result userStart_1(){ //放入页数拿到他对应的分


        Map<String, USerStateModel> sMap = songServer.userStart();

        Double lingDao=0.0;
        Double pingWei=0.0;
        Double guanZhon=0.0;
        Double danqian=0.0;
        Double maxGrade=0.0;
        Double minGrade=100.0;
        SongModel songModel = new SongModel();
        VoteSumModel vote = new VoteSumModel();
        for (String som : sMap.keySet()) {
            USerStateModel user = sMap.get(som);
            int i = songServer.begin == 0 ? 1 : songServer.begin-1;
            for(SongModel k:user.getSongModel()){ //查找比较评委 便利每一个评委

                if(k.getId()==i){
                    vote.setSonglist(k.getName());//拿不到
//                    System.out.println(k.getName());
                    Double grade =k.getGrade();

                    if(grade==0){ //如果评分为0的话默认先给到8分
                        songModel.setName(k.getName());
                        songModel.setId(k.getId());
                        grade=8.0;
                    }

                    if(user.getJurisdiction().equals("评委")){
                        if(grade<minGrade){ //找到最大
                            minGrade=grade;
                        }
                        if(maxGrade<grade){ //找到最小
                            maxGrade=grade;
                        }

                        pingWei+=grade;
                    }else if(user.getJurisdiction().equals("领导")){
                        lingDao+=grade;
                    }else if(user.getJurisdiction().equals("群众")){
                        guanZhon+=grade;
                    }
                }
            }
        }
        pingWei=pingWei-maxGrade-minGrade; //计算出来他的差
        lingDao = lingDao/2.0; //两个人
        pingWei = pingWei/6.0;//6个人
//        guanZhon=guanZhon;
        danqian=lingDao*0.6+pingWei*0.3+guanZhon*0.1;



        vote.setUser_grade(guanZhon);
        vote.setJudge_grade(pingWei);
        vote.setLeadership_grade(lingDao);
        vote.setGrade(danqian);


        Vote_Song_Model user_list_model = new Vote_Song_Model();
        user_list_model.setSongModel(songModel);
        user_list_model.setVote(vote);
        songModel.setGrade(danqian);

        return Result.success(user_list_model);
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
        System.out.println(name+"登入成功");
        return Result.success(jwt);
    }



}
