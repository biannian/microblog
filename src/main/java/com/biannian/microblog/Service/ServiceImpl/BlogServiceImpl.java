package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.BlogMapper;
import com.biannian.microblog.Entity.BlogInfo;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper mapper;

    @Override
    public List<BlogInfo> getBlogInfo () {
        List<BlogInfo> blogInfos = mapper.getBlogInfo();
        return blogInfos;
    }

    @Override
    public List<BlogInfo> getBlogDetail(String blogId) {
        List<BlogInfo> a = mapper.getBlogDetail(blogId);
        return a;
    }
}
