package com.xsw.neo.service.controller;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xueshengwen
 * @since 2021/7/9 9:40
 */
public class Demo1 {

    public static void main(String[] args) {
        List<Integer> numList = Lists.newArrayList();
        numList.add(99);
        numList.add(2);
        numList.add(390);
        numList.add(28);

        List<Integer> sortedNumbers = numList.stream().sorted().collect(Collectors.toList());
        Console.log(sortedNumbers);

        List<String> list = Lists.newArrayList();
        list.add("bbb");
        list.add("aaa");
        list.add("ddd");
        list.add("ccc");

        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        Console.log(collect);
    }
}
