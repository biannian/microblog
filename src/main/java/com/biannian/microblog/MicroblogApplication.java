package com.biannian.microblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.biannian.microblog.Dao")
public class MicroblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroblogApplication.class, args);
    }

}
