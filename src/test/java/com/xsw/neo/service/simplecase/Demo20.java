package com.xsw.neo.service.simplecase;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xueshengwen
 * @since 2021/3/19 16:27
 */
public class Demo20 {

    public static void main(String[] args) {

        // compareTo 实现机制：对于字符串来说，字典排序规则；对于数字来说，直接按照大小排序
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1, 110);
        map.put(2, 1010100110);
        map.put(3, 120);
        map.put(4, 130);

        // TreeMap不适合key为String类型的排序 如果key为Long或者Integer可以
        Map<String, Integer> map1 = new TreeMap<>();
        map1.put("零级告警", 110);
        map1.put("一级告警", 1010100110);
        map1.put("二级告警", 120);
        map1.put("三级告警", 130);

        Map<String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("零级告警", 1011111);
        hashMap.put("一级告警", 110);
        hashMap.put("二级告警", 120);
        hashMap.put("三级告警", 130);

        System.out.println(map);
        System.out.println(map1);
        System.out.println(hashMap);
    }
}
