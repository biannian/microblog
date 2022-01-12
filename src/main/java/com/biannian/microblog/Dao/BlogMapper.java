package com.biannian.microblog.Dao;

import com.biannian.microblog.Entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
public interface BlogMapper {
    List<BlogInfo> getBlogInfo();
}
