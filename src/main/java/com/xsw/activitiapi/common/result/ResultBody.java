package com.xsw.activitiapi.common.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public static <T> ResultBody<T> SUCCESS(T data) {
        return new ResultBody(true, "success", data);
    }

    public static <T> ResultBody<T> FAIL(String message) {
        return new ResultBody(false, message, null);
    }
}
