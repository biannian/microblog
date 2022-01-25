package com.biannian.microblog.Dao;

import com.biannian.microblog.Entity.BlogImg;
import com.biannian.microblog.Entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlogMapper {
    List<BlogInfo> getBlogInfo();

    List<BlogInfo> getBlogDetail(String blogId);

    int uploadBlog(BlogInfo blogInfo);

    int likeBlog(String blogId, String userId, Date time);

    int notLikeBlog(String blogId, String userId);

    int addBlogImg(List<BlogImg> imgs, int blogId);
}
