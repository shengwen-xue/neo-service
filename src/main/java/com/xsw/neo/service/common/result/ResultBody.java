package com.xsw.neo.service.common.result;


import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBody<T> implements Serializable {
    /**
     * 标识位
     */
    private Boolean flag;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public static <T> ResultBody<T> SUCCESS(T data, String message) {
        ResultBody resultBody = new ResultBody();
        resultBody.setFlag(true);
        resultBody.setMessage(message);
        resultBody.setData(data);
        return resultBody;
    }

    public static <T> ResultBody<T> SUCCESS(T data) {
        ResultBody resultBody = new ResultBody();
        resultBody.setFlag(true);
        resultBody.setMessage("SUCCESS");
        resultBody.setData(data);
        return resultBody;
    }

    public static <T> ResultBody<T> SUCCESS() {
        ResultBody resultBody = new ResultBody();
        resultBody.setFlag(true);
        resultBody.setMessage("SUCCESS");
        resultBody.setData("");
        return resultBody;
    }

    public static <T> ResultBody<T> FAIL(String message) {
        ResultBody resultBody = new ResultBody();
        resultBody.setFlag(false);
        resultBody.setMessage(message);
        resultBody.setData("");
        return resultBody;
    }
}
