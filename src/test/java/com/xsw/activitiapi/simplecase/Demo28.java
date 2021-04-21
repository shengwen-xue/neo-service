package com.xsw.activitiapi.simplecase;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/4/15 11:40
 */
public class Demo28 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("tom", "jerry", "leo", "mark", "tony", "tyler");
        List<List<String>> partition = Lists.partition(list, 5);

        for (String name : partition.get(0)) {
            System.out.println(name);
        }
        System.out.println(partition.get(0));
    }
}
