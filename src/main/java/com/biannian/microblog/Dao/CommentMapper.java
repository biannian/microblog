package com.biannian.microblog.Dao;

import com.biannian.microblog.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    int addComment(Comment comment);

    int likeComment(Comment comment);
}
