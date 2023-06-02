package com.example.beans;

/**
 * @Classname HttpResponseEntity
 * @Description TODO
 * @PackageName com.example.bean
 * @Version 1.0.0
 * @Date 2023/6/2 18:57
 * @Created by HE YU
 */
public class HttpResponseEntity {
    private String code;//状态码
    private Object data;//往返数据
    private String message;//状态信息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
