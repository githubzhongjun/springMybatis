package com.example.springmybatis.common;

import java.util.Map;

public class ResponseResult {
    private Map<String, Object> body;

    private Integer code;

    private String message;

    public ResponseResult(Map<String, Object> body, Integer code, String message) {
        this.body = body;
        this.code = code;
        this.message = message;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
