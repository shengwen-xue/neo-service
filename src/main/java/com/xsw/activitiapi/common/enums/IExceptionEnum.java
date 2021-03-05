package com.xsw.activitiapi.common.enums;

/**
 * @author xueshengwen
 * @since 2021/3/4 11:46
 */
public interface IExceptionEnum {

    /**
     * 获取返回值
     *
     * @return 值
     */
    int getCode();

    /**
     * 获取返回消息
     *
     * @return 消息
     */
    String getMessage();
}
