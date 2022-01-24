package com.biannian.microblog.Entity;

import lombok.Data;

/**
 * 微博图片
 */
public class BlogImg {
    private int imgId;
    private String imgUrl;
    private int blogId;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public BlogImg() {
    }

    public BlogImg(int imgId, String imgUrl, int blogId) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
        this.blogId = blogId;
    }
}
