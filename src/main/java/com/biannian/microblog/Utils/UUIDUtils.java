package com.biannian.microblog.Utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        String uid = id.replaceAll("-", "");

        return uid;
    }
}