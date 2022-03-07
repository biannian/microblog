package com.biannian.microblog.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class GlanceHistroy {
    private String browserName;
    private String glanceIp;
    private Date glanceTime;
    private String city;
}
