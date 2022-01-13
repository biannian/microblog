package com.biannian.microblog.Entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

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
    private Timestamp blogTime;
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
    private Timestamp blogCreatTime;
}
