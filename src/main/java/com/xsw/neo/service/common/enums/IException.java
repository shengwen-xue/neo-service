package com.xsw.neo.service.common.enums;

/**
 * 异常接口
 *
 * @author xueshengwen
 * @since 2021/3/4 11:46
 */
public interface IException {

    /**
     * 获取返回值
     *
     * @return 值
     */
    Integer getCode();

    /**
     * 获取返回消息
     *
     * @return 消息
     */
    String getMessage();
}
