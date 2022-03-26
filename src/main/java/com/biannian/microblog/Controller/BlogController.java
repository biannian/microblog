package com.biannian.microblog.Controller;

import com.biannian.microblog.Entity.BlogDraft;
import com.biannian.microblog.Entity.BlogImg;
import com.biannian.microblog.Entity.BlogInfo;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping({"/Blog"})
@RestController
public class BlogController {
    @Autowired
    private BlogService service;

    /**
     * 获取微博列表信息
     *
     * @return
     */
    @RequestMapping({"/getBlogInfo"})
    public Result<?> getBlogInfo(String userId) {
        return Result.success(service.getBlogInfo(userId));
    }

    /**
     * 获取微博详情
     *
     * @param blogId
     * @return
     */
    @RequestMapping({"/getBlogDetail"})
    public Result<?> getBlogDetail(String blogId) {
        return Result.success(service.getBlogDetail(blogId));
    }

    /**
     * 给微博点赞
     *
     * @param blogId
     * @param userId
     * @return
     */
    @RequestMapping({"/likeBlog"})
    public Result<?> likeBlog(String blogId, String userId) {
        return Result.success(service.likeBlog(blogId, userId));
    }
    /**
     * 给微博取消点赞
     *
     * @param blogId
     * @param userId
     * @return
     */
    @RequestMapping({"/notLikeBlog"})
    public Result<?> notLikeBlog(String blogId, String userId) {
        return Result.success(service.notLikeBlog(blogId, userId));
    }

    /**
     * 保存微博备份
     *
     * @param blogDraft
     * @return
     */
    @RequestMapping({"/saveBlogDraft"})
    public Result<?> saveBlogDraft(BlogDraft blogDraft) {
        return Result.success(service.saveBlogDraft(blogDraft));
    }

    /**
     * 发布微博
     *
     * @param blogInfo
     * @return
     */
    @RequestMapping({"/uploadBlog"})
    public Result<?> uploadBlog( BlogInfo blogInfo) {
        if (service.uploadBlog(blogInfo) == 1){
            return Result.success();
        }
        return Result.fail();
    }
}
