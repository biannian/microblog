package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.CommentMapper;
import com.biannian.microblog.Entity.Comment;
import com.biannian.microblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;

    @Override
    public int addComment(Comment comment) {
        comment.setCommentTime(new Date());
        return mapper.addComment(comment);
    }

    @Override
    public int likeComment(Comment comment) {
        comment.setCommentTime(new Date());
        return mapper.likeComment(comment);
    }
}
