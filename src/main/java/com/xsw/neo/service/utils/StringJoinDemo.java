package com.xsw.neo.service.utils;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author xueshengwen
 * @since 2021/8/12 11:22
 */
public class StringJoinDemo {

    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner("-");
        stringJoiner.add("111").add("222").add("333");

        String collect = Arrays.asList("aaa", "bbb", "ccc").stream().collect(Collectors.joining("-"));

        String join = Joiner.on("|").join(Arrays.asList("xxx", "yyy", "zzz"));

        System.out.println(stringJoiner.toString());
        System.out.println(collect);
        System.out.println(join);
    }
}
