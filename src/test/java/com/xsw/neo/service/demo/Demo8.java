package com.xsw.neo.service.demo;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xueshengwen
 * @since 2021/5/31 16:34
 */
public class Demo8 {

    public static int countSortNum(String str) {
        String[] split = str.split("");

        List<String> strings = new ArrayList<>();
        // strings.add(str);

        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;

        // ASA AAS SAA
        for (int i = 0; i < split.length; i++) {
            System.out.println("当前字符:" + split[i]);
            stringBuilder.append(split[i]);

            for (int j = 0; j < split.length; j++) {
                if (split[count] == split[j]) {

                }

            }


            char[] arr = new char[split.length - 1];


            count++;
            if (count == split.length) {
                strings.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                count = 0;
            }
        }

        System.out.println("集合：" + strings);

        return strings.stream().distinct().collect(Collectors.toList()).size();
    }


    public static int findOneNum(Integer[] arr) {
        // {2，2，1，1，4，4，7}
        Map<Integer, Integer> map = Maps.newHashMap();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        map.forEach((key, value) -> {
            System.out.println("key:" + key);
            System.out.println("value:" + value);
        });

        Integer result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }
        return result;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        return null;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        System.out.println();

    }


    public static void main(String[] args) {
//        while (true) {
//            System.out.println("请输入一个字符串:");
//            Scanner scanner = new Scanner(System.in);
//            String next = scanner.next();
//            if (next.equals("exit")) {
//                break;
//            } else {
//                if (next.length() > 0 && next.length() < 10) {
//                    countSortNum(next);
//                } else if (next.length() > 10) {
//                    System.out.println("输入的字符串长度不能超过10");
//                } else {
//                    System.out.println("不能输入空字符串");
//                }
//            }
//        }

//        Integer[] arr = {2, 2, 1, 1, 4, 4, 7};
//        System.out.println(findOneNum(arr));

//        ListNode head = new ListNode(0);
//
//        ListNode fistNode = new ListNode(1);
//        ListNode secondNode = new ListNode(2);
//        ListNode thirdNode = new ListNode(3);
//
//        head.val = 1;
//        head.setNext(fistNode);
//        fistNode.setNext(secondNode);
//        secondNode.setNext(thirdNode);
//
//        System.out.println("thirdNode的值为：" + head.getNext().getNext().getNext().getVal());
//        System.out.println("head的值为：" + head.getVal());
//        System.out.println("head：" + head);

        int[] arr = {2, 2, 1};
        int[] arr1 = {2, 2, 1};
        merge(arr, 3, arr1, 3);
    }
}

@Data
class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
