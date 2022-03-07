package com.biannian.microblog.Entity;


import lombok.Data;

import java.util.Date;

/**
 * 发送email历史
 */
@Data
public class EmailHistory {
    private int verifyCodeId;
    private String VerifyCode;
    private String email;
    private Date creatTime;
    private String sendStatus;
}
