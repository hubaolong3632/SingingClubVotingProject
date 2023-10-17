package com.example.singingclubvotingproject.config;

import com.example.singingclubvotingproject.idao.ILoginDao;
import com.example.singingclubvotingproject.idao.ISongDao;
import com.example.singingclubvotingproject.model.SongModel;
import com.example.singingclubvotingproject.model.USerStateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 启动的时候自动执行的方法
@Component
public class MyBean implements CommandLineRunner {
    @Autowired
    public ISongDao iSongDao;

    @Autowired
    public ILoginDao iLoginDao;

    @Bean
    public List<SongModel> songModels(){
        System.out.println("执行载入所有节目单");
        List<SongModel> songModels = iSongDao.from_songList();

        return songModels;
    }

    @Bean
    public Map<String,USerStateModel> userStart(List<SongModel> songModels){
        System.out.println("载入初始化领导");
        List<String> strings = iLoginDao.from_login_user();
        Map<String,USerStateModel> userList=new HashMap<>();



        for (String userName : strings){

            List<SongModel> aa1=new ArrayList<>();
           for(SongModel s1:songModels){
               SongModel songModel1 = new SongModel();
               songModel1.setGrade(s1.getGrade());
               songModel1.setaBoolean(s1.getaBoolean());
               songModel1.setId(s1.getId());
               songModel1.setName(s1.getName());
               aa1.add(songModel1);
           }


            USerStateModel stateModel = new USerStateModel();
            stateModel.setName(userName);//用户姓名
            stateModel.setState(false);//在线状态为不在线
            stateModel.setSongModel(aa1); //拿到所有节目单
            System.out.println("地址"+aa1);
            userList.put(userName,stateModel);
        }

        return userList;
    }




    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动完成");


    }
}