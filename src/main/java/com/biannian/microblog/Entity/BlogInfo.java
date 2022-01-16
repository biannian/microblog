package com.biannian.microblog.Entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 微博信息
 */
@Data
public class BlogInfo {
    /*
     * 微博主键
     */
    private int blogId;
    /*
    微博内容
     */
    private String blogInfo;
    /*
    微博作者编号
     */
    private int blogAuthorId;
    /*
    微博图片地址
     */
    private List<BlogImg> blogImg;
    /*
    微博时间
     */
    private Date blogTime;
    /*
    微博地址
     */
    private String blogLocation;
    /*
    转发次数
     */
    private int repeatCount;
    /*
    回复次数
     */
    private int messageCount;
    /*
    点赞次数
     */
    private int likeCount;
    /*
    微博创建时间
     */
    private Date blogCreatTime;
    /*
     *该用户是否点赞
     */
    private boolean  liked;
    /*
    评论
     */
    private List<Comment> comment;
    /*
    用户头像信息
     */
    private User user;
    /*
    来源
     */
    private String blogFrom;
}
