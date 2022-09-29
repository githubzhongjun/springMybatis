package com.example.springmybatis.common;

public enum Code {
    success(10000,"成功"),

    fail(10001,"失败"),

    error(10002,"错误");

    private Integer code;

    private String info;

    Code(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer build(){
        return this.code;
    }
}
