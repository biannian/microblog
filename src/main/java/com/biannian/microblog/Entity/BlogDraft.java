package com.biannian.microblog.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 发微博备用
 */
@Data
public class BlogDraft {
    private int draftId;
    private int userId;
    private String draftInfo;
    private String location;
    private Date createTime;
}
