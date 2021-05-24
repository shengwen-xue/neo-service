package com.xsw.neo.service.common.enums;

import com.xsw.neo.service.common.exception.IException;

/**
 * 业务枚举
 *
 * @author xueshengwen
 * @since 2021/3/4 11:44
 */
public enum BusinessEnum implements IException {

    CANNOT_INSERT_THE_SAME_ID(10001, "不能插入相同的ID"),

    NOT_FOUND_STUDENT(10002, "未查询到该学生"),

    PASSWORD_ERROR(10003, "密码错误"),

    PARAMETER_IS_EMPTY(10004, "传入参数为空"),

    COLLECTION_IS_EMPTY(10005, "查询集合为空");

    private final Integer code;

    private final String message;

    public static BusinessEnum getBusinessEnum(Integer code) {
        for (BusinessEnum businessEnum : BusinessEnum.values()) {
            if (code.equals(businessEnum.getCode())) {
                return businessEnum;
            }
        }
        return null;
    }

    public static String getEnumCode(Integer code) {
        for (BusinessEnum businessEnum : BusinessEnum.values()) {
            if (code.equals(businessEnum.getCode())) {
                return businessEnum.getMessage();
            }
        }
        return null;
    }

    public static Integer getEnumName(String name) {
        for (BusinessEnum businessEnum : BusinessEnum.values()) {
            if (name.equals(businessEnum.getMessage())) {
                return businessEnum.getCode();
            }
        }
        return null;
    }

    BusinessEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }}
