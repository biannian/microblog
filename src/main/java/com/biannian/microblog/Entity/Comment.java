package com.biannian.microblog.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 评论
 */
@Data
public class Comment {
    private int commentId;
    private int blogId;
    private int userId;
    private String commentInfo;
    private Date commentTime;
    private int likeCount;
    private int msgCount;
    /*
    上级评论id
     */
    private int higherId;
    /*
  用户头像信息
   */
    private User user;
    /*
    是否点赞
     */
    private boolean isCommentLike;
}
