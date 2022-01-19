package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.UserMapper;
import com.biannian.microblog.Entity.User;
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
}
