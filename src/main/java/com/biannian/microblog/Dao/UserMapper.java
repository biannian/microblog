package com.biannian.microblog.Dao;

import com.biannian.microblog.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUserInfo(String userId);

    List<User> login(String account, String password);

    void addWrongCount(String account,int wrongCount);

    User getWrongCount(String account);
}
