package com.xsw.neo.service.demo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xueshengwen
 * @since 2021/5/17 10:05
 */
public class Demo2 {

    public static void main(String[] args) {
        String a = "111";

        String b = null;

        if (StringUtils.equals(a, b)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
