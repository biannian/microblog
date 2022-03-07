package com.biannian.microblog.Dao;

import com.biannian.microblog.Entity.Account;
import com.biannian.microblog.Entity.EmailHistory;
import com.biannian.microblog.Entity.GlanceHistroy;
import com.biannian.microblog.Entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUserInfo(String userId);

    List<User> login(String account, String password);

    void addWrongCount(String account,int wrongCount);

    User getWrongCount(String account);

    void saveEmailHistory(EmailHistory emailHistory);

    void saveGlance(GlanceHistroy glanceHistroy);

    void register(Account user);

    void addUser(User user);

    List<Account> queryEmail(String email);
}
