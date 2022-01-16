package com.biannian.microblog.Entity;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class User {
    private int userId;

    private String userName;
    /*
    头像
     */
    private String userImgUrl;
    /*
    账户id
     */
    private int accountId;
    /*
    喜欢类型
     */
    private String likeType;

}
