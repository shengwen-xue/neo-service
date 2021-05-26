package com.xsw.neo.service.simplecase;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.assertj.core.util.Arrays;

import java.util.List;
import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/4/19 19:48
 */
public class Demo29 {

    private static void deleteElement(Integer... number) {
        System.out.println(number + "删除成功");
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Maps.newHashMap();

        List<Integer> numbers = Lists.newLinkedList();
        numbers.add(1);
        numbers.add(2);

        numbers.forEach(item -> {
            deleteElement(item);
        });
    }
}
