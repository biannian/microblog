package com.biannian.microblog.Service;

import com.biannian.microblog.Entity.EmailHistory;
import com.biannian.microblog.Entity.GlanceHistroy;
import com.biannian.microblog.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserInfo(String userId);

    List<User> login(String account, String password);

    User addWrongCount(String account);

    void saveEmailHistory(EmailHistory emailHistory);

    void saveGlance(GlanceHistroy glanceHistroy);
}
