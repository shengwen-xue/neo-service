package com.xsw.activitiapi.simplecase;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author xueshengwen
 * @since 2021/4/2 15:21
 */
public class Demo25 {

    public static void main(String[] args) {
        String[] array = {"1", "2"};
        if (ArrayUtils.isNotEmpty(array)) {
            System.out.println("null");
        }
        Console.log(array);
    }
}
