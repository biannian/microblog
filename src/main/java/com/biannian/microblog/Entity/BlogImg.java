package com.biannian.microblog.Entity;

import lombok.Data;

@Data
public class BlogImg {
    private int imgId;
    private String imgUrl;
    private int blogId;
}
