package com.xsw.activitiapi.simplecase;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/3/24 15:09
 */
public class Demo22 {

    public static void main(String[] args) {
        int offset = 10;
        List<String> arrayList = Arrays.asList("Tom", "Jerry", "Max", "Min", "Soul", "Sony", "God", "Mon", "Coll", "leo", "111", "222");
        List<String> list = new LinkedList<>(arrayList);
        System.out.println("删除前：" + list);
        Iterator<String> iterator = list.iterator();
        String target = list.get(offset);
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals(target)) {
                iterator.remove();
            }
        }
        String[] array = list.toArray(new String[list.size()]);
        String s = list.get(0);
        String s1 = list.get(offset);

        String[] strings = Arrays.copyOfRange(array, list.indexOf(s), list.indexOf(s1));
        List<String> list1 = Arrays.asList(strings);

        System.out.println("删除后：" + list1);
        list.clear();
        list = list1;
        System.out.println(list);
    }
}
