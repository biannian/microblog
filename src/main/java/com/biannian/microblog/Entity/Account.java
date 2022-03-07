package com.biannian.microblog.Entity;

import lombok.Data;

@Data
public class Account {
    private int accountId;
    /*
    账户名
     */
    private String account;
    /*
    密码
    */
    private String password;
    /*
    邮箱号
    */
    private String email;

}
