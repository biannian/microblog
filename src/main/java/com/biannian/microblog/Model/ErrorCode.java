package com.biannian.microblog.Model;

public enum ErrorCode {
    USERNAME_OR_PASSWORD_ERROR(100, "用户名或密码错误");
    private Integer value;

    private String desc;

    ErrorCode(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
