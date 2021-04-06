package com.xsw.activitiapi.simplecase;

import com.xsw.activitiapi.common.enums.BusinessEnum;

/**
 * @author xueshengwen
 * @since 2021/4/6 10:52
 */
public class Demo26 {

    public static void main(String[] args) {
        BusinessEnum businessEnum = BusinessEnum.getBusinessEnum(10001);
        System.out.println(businessEnum);

        String code = BusinessEnum.getEnumCode(10001);
        System.out.println(code);

        Integer enumCode = BusinessEnum.getEnumName("未查询到该用户");
        System.out.println(enumCode);


    }
}
