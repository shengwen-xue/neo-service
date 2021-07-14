package com.xsw.neo.service.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共异常类
 *
 * @author xueshengwen
 * @since 2021/3/5 10:47
 */
@Data
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

    public CommonException(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
