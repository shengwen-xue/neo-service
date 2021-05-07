package com.xsw.neo.service.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

/**
 * 公共异常类
 *
 * @author xueshengwen
 * @since 2021/3/5 10:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonException extends RuntimeException {

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

    public CommonException(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
