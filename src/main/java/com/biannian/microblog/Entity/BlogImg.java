package com.biannian.microblog.Entity;

import lombok.Data;

/**
 * 微博图片
 */
@Data
public class BlogImg {
    private int imgId;
    private String imgUrl;
    private int blogId;
}
