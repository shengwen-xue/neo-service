package com.xsw.neo.service.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 手机号码处理工具类
 *
 * @author xueshengwen
 * @since 2021/5/14 11:33
 */
public class PhoneNumberUtils {

    private PhoneNumberUtils() {
    }

    /**
     * 手机号格式校验正则
     */
    private static final String PHONE_REGEX = "^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$";

    /**
     * 手机号脱敏筛选正则
     */
    private static final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号脱敏替换正则
     */
    private static final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";

    /**
     * 手机号格式校验
     *
     * @param phoneNumber 手机号
     * @return 标识
     */
    public static final boolean checkPhone(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }
        return phoneNumber.matches(PHONE_REGEX);
    }

    /**
     * 手机号脱敏处理
     *
     * @param phoneNumber 手机号
     * @return 脱敏后的手机号
     */
    public static final String blurPhone(String phoneNumber) {
        boolean checkFlag = checkPhone(phoneNumber);
        if (!checkFlag) {
            throw new IllegalArgumentException("手机号格式不正确!");
        }
        return phoneNumber.replaceAll(PHONE_BLUR_REGEX, PHONE_BLUR_REPLACE_REGEX);
    }
}
