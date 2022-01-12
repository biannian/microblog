package com.biannian.microblog.Controller;

import com.biannian.microblog.Entity.BlogInfo;
import com.biannian.microblog.Model.Result;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping({"/Blog"})
@RestController
public class BlogController {
    @Autowired
    private BlogService service;

    @RequestMapping({"/getBlogInfo"})
    public Result<?> getBlogInfo() {
        return Result.success(service.getBlogInfo());
    }
}
