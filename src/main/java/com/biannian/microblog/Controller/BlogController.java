package com.biannian.microblog.Controller;

import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping({"/Blog"})
@RestController
public class BlogController {
    @Autowired
    private BlogService service;

    @RequestMapping({"/getBlogInfo"})
    public Result<?> getBlogInfo() {
        return Result.success(service.getBlogInfo());
    }

    @RequestMapping({"/getBlogDetail"})
    public Result<?> getBlogDetail(String blogId) {
        return Result.success(service.getBlogDetail(blogId));
    }
    @RequestMapping({"/likeBlog"})
    public Result<?> likeBlog(String blogId,String userId) {
        return Result.success(service.getBlogDetail(blogId));
    }
}
