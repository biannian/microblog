package com.biannian.microblog.Service;

import com.biannian.microblog.Entity.BlogDraft;
import com.biannian.microblog.Entity.BlogInfo;

import java.util.List;

public interface BlogService {
    List<BlogInfo> getBlogInfo();

    List<BlogInfo> getBlogDetail(String blogId);

    int likeBlog(String blogId, String userId);

    int uploadBlog(BlogInfo blogInfo);

    int saveBlogDraft(BlogDraft blogDraft);

    int notLikeBlog(String blogId, String userId);
}
