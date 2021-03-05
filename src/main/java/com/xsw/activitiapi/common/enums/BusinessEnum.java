package com.xsw.activitiapi.common.enums;

/**
 * @author xueshengwen
 * @since 2021/3/4 11:44
 */
public enum BusinessEnum implements IExceptionEnum {

    NOT_FOUND_USER(10001, "未查询到该用户"),

    NOT_FOUND_STUDENT(10002, "未查询到该学生"),

    PASSWORD_ERROR(10003, "密码错误"),

    PARAMETER_IS_EMPTY(10004, "传入参数为空"),

    COLLECTION_IS_EMPTY(10005, "查询集合为空");

    private final int code;

    private final String message;

    BusinessEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }}
