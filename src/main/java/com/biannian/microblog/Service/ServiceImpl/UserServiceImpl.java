package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.UserMapper;
import com.biannian.microblog.Entity.Account;
import com.biannian.microblog.Entity.EmailHistory;
import com.biannian.microblog.Entity.GlanceHistroy;
import com.biannian.microblog.Entity.User;
import com.biannian.microblog.Model.CurrentIp;
import com.biannian.microblog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> getUserInfo(String userId) {
        return mapper.getUserInfo(userId);
    }

    @Override
    public List<User> login(String account, String password) {
        return mapper.login(account, password);
    }

    @Override
    public User addWrongCount(String account) {
        User user = mapper.getWrongCount(account);
        mapper.addWrongCount(account, user.getWrongCount() + 1);
        return user;
    }

    @Override
    public void saveEmailHistory(EmailHistory emailHistory) {
        mapper.saveEmailHistory(emailHistory);
    }

    @Override
    public void saveGlance(GlanceHistroy glanceHistroy) {
        mapper.saveGlance(glanceHistroy);
    }

    @Override
    public void register(Account user) {
        mapper.register(user);
        User addUserInfo = new User();
        addUserInfo.setAccountId(user.getAccountId());
        addUserInfo.setUserImgUrl("/images/avatar/moren.jpg");
        addUserInfo.setUserName("微博用户" + user.getAccountId());
        mapper.addUser(addUserInfo);
    }

    @Override
    public List<Account> queryEmail(String email) {
        return mapper.queryEmail(email);
    }

}
