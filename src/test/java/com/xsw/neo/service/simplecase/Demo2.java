package com.xsw.neo.service.simplecase;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 拼接测试
 *
 * @author xueshengwen
 * @since 2020/12/22 13:36
 */
public class Demo2 {

    public static void main(String[] args) {
        List<Object> objectList = Stream.builder()
                .add("a")
                .add("b")
                .add("c")
                .build()
                .collect(Collectors.toList());
        String collect = Stream.of("a", "b", "C").collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println(objectList.size());
        StringJoiner stringJoiner = new StringJoiner("|", "(", ")");

        stringJoiner.add("a");
        stringJoiner.add("b");
        stringJoiner.add("c");
        stringJoiner.add("d");
        System.out.println(stringJoiner.toString());
        String strip = StringUtils.strip("1");
        System.out.println(strip);
        String join = StringUtils.join(objectList, "-");
        System.out.println(join);
    }
}
