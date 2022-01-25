package com.biannian.microblog.Controller;

import com.biannian.microblog.Entity.Comment;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/Comment"})
@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    /**
     * 评论
     *
     * @param comment
     * @return
     */
    @RequestMapping({"/addComment"})
    public Result<?> addComment(Comment comment) {
        return Result.success(service.addComment(comment));
    }
}
