package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.BlogMapper;
import com.biannian.microblog.Entity.BlogInfo;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper mapper;

    @Override
    public List<BlogInfo> getBlogInfo () {
        return mapper.getBlogInfo();
    }

    @Override
    public List<BlogInfo> getBlogDetail(String blogId) {
        List<BlogInfo> blogInfos =  mapper.getBlogDetail(blogId);

        return mapper.getBlogDetail(blogId);
    }
}
