package com.example.singingclubvotingproject.server;

import com.example.singingclubvotingproject.idao.ILoginDao;
import com.example.singingclubvotingproject.idao.ISongDao;
import com.example.singingclubvotingproject.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import utio.UtioCode.Result;
import utio.UtioY;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SongServer {
    @Resource
    private List<SongModel> songModels;

    @Resource
    private Map<String, USerStateModel> userStart;

    @Resource
    private ISongDao iSongDao;





    //    拿到所有数据集合
    public List<SongModel> getSongModels() {
        return songModels;
    }



//    投票完成要跳转的
    public    Integer begin=0;
    private  Integer end=1;


//    发起投票
    public void initLateVote(Integer begin,Integer end) {
       this.begin=begin;
       this.end=end;
    }


    //   返回所有用户投票信息
    public Map<String, USerStateModel> userStart() {
        return userStart;
    }

//    用户添加投票 名字和分数
    public Boolean addVote(UserVoteModel userVoteModel) { //投票分数和投票人名字

        userVoteModel.setDate(UtioY.Date_getDate());//设置时间
        userVoteModel.setSong(begin);//设置投票id
        Integer integer = iSongDao.insert_userVote(userVoteModel); //插入数据库
        if (integer==1){
//            System.out.println(begin);
            USerStateModel uSerStateModel = userStart.get(userVoteModel.getName());
//            System.out.println(uSerStateModel);

            List<SongModel> songModel = uSerStateModel.getSongModel();

//            System.out.println(songModel);
            SongModel songModel1 = songModel.get(songModel.indexOf(new SongModel(begin))); //查找到投票的人地点

//            System.out.println(songModel1);
            songModel1.setGrade(userVoteModel.getGrade()); //设置分数
            songModel1.setaBoolean(true); //设置投票状态

            return true;
        }
        return false;
    }

    public Boolean qd=false;

//  返回用户便利的数据
    public OperateModel timerFrom(String userName){
        OperateModel operateModel = new OperateModel(); //设置界面跳转

        USerStateModel uSerStateModel = userStart.get(userName);
        List<SongModel> songModel = uSerStateModel.getSongModel(); //当前用户的个人投票信息
        SongModel songModel1 = songModel.get(songModel.indexOf(new SongModel(begin == 0 ? 1 : begin))); //查找到投票的人的信息
//        System.out.println(songModel1.getName());
        if(qd==false||songModel1.getName().equals("结束")){ //如果是刚刚开始默认 显示第一个界面
            operateModel.setTechweb(1);
            operateModel.setSeiect(end); //如果投过就显示下一个网页界面
        }
        else if(songModel1.getaBoolean()==true){ //判断是否给当前节目投票
//            System.out.println("第一个");
            operateModel.setTechweb(1);
            operateModel.setSeiect(end); //如果投过就显示下一个网页界面
        }else{
//            if(){
                operateModel.setTechweb(2);
                operateModel.setSeiect(begin); //如果没投过就显示当前界面
//            }
//            System.out.println("第二个");

        }


        operateModel.setData(songModel); //个人投票数据
        operateModel.setUserName(userName); //个人姓名


        uSerStateModel.setDate(new Date()); //设置当前访问时间
        return operateModel;
    }






}
