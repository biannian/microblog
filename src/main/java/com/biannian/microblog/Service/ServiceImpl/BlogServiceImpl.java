package com.biannian.microblog.Service.ServiceImpl;

import com.biannian.microblog.Dao.BlogMapper;
import com.biannian.microblog.Entity.BlogDraft;
import com.biannian.microblog.Entity.BlogImg;
import com.biannian.microblog.Entity.BlogInfo;
import com.biannian.microblog.Entity.Comment;
import com.biannian.microblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper mapper;

    @Override
    public List<BlogInfo> getBlogInfo(String userId) {
        List<BlogInfo> blogInfos = mapper.getBlogInfo(userId);
        this.sortList(blogInfos);
        return blogInfos;
    }

    @Override
    public List<BlogInfo> getBlogDetail(String blogId) {
        List<BlogInfo> blogInfos = mapper.getBlogDetail(blogId);
        this.sortList(blogInfos);
        return blogInfos;
    }

    @Override
    public int likeBlog(String blogId, String userId) {
        return mapper.likeBlog(blogId, userId, new Date());
    }

    @Override
    public int notLikeBlog(String blogId, String userId) {
        return mapper.notLikeBlog(blogId, userId);
    }

    @Override
    public int uploadBlog(BlogInfo blogInfo) {
        blogInfo.setBlogTime(new Date());
        blogInfo.setBlogCreateTime(new Date());
        int result = mapper.uploadBlog(blogInfo);
        if (result == 1 && null != blogInfo.getBlogImg()) {
            List<BlogImg> imgs = blogInfo.getBlogImg();
            mapper.addBlogImg(imgs, blogInfo.getBlogId());
        }
        return result;
    }

    @Override
    public int saveBlogDraft(BlogDraft blogDraft) {
        return 0;
    }

    /**
     * 按图片id来排序
     *
     * @param blogInfos
     * @return
     */
    private List<BlogInfo> sortList(List<BlogInfo> blogInfos) {
        for (BlogInfo blog : blogInfos
        ) {
            blog.getBlogImg().sort(Comparator.comparing(BlogImg::getImgId));
            blog.setBlogTimeDiffer(this.formatTime(blog.getBlogTime()));
            if (null != blog && null != blog.getComment()) {
                for (Comment comment : blog.getComment()
                ) {
                    comment.setCommentTimeDiffer(this.formatTime(comment.getCommentTime()));
                }
            }
        }
        return blogInfos;
    }

    /**
     * 对时间进行处理
     *
     * @param time
     * @return
     */
    private String formatTime(Date time) {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateDiffer = null;
        long date = (nowDate.getTime() - time.getTime()) / 1000;
        if (60 > date) {
            dateDiffer = date + "秒前";
        }
        if (60 * 60 > date && date > 60) {
            dateDiffer = date / 60 + "分钟前";
        }
        if (24 * 60 * 60 > date && date > 60 * 60) {
            dateDiffer = date / (60 * 60) + "小时前";
        }
        if (date > 24 * 60 * 60) {
            dateDiffer = sdf.format(time);
        }
        return dateDiffer;
    }
}
