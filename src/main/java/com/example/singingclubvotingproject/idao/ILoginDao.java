package com.example.singingclubvotingproject.idao;

import com.example.singingclubvotingproject.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ILoginDao {
        public List<UserModel> from_login_user();
        public UserModel login(@Param("user") UserModel user);
}
