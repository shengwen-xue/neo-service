package com.xsw.activitiapi.simplecase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xueshengwen
 * @since 2021/2/24 11:28
 */
public class Demo17 {

    public static void main(String[] args) {

        List<Integer> ages = Arrays.asList(1,2,1,1,1,2,3,4,4,4,4);
        List<Integer> stream = ages.stream().distinct().collect(Collectors.toList());
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(ages);
        ArrayList<Integer> list = new ArrayList<>(linkedHashSet);

        System.out.println(ages);
        System.out.println(stream);
        System.out.println(linkedHashSet);
        System.out.println(list);
    }
}
