package com.biannian.microblog.Service;

import com.biannian.microblog.Entity.BlogInfo;

import java.util.List;

public interface BlogService {
    List<BlogInfo> getBlogInfo();

    List<BlogInfo> getBlogDetail(String blogId);
}
