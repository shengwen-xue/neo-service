package com.xsw.neo.service.simplecase;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode算法题
 *
 * @author xueshengwen
 * @since 2020/12/22 13:39
 */
public class Demo3 {

    public static int[] twoSum(int[] nums, int target) {
        return null;
    }

    public static int[] plusOne(int[] digits) {
        int[] ints = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            ints[i] = digits[i];
            int v = digits[digits.length - 1] + 1;
            if (v < 10) {
                ints[ints.length - 1] = v;
            } else {
                ints[0] = v / 10;
                ints[1] = v % 10;
            }
        }
        return ints;
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        String str = "";
        for (int i = 0; i < split.length; i++) {
            str = split[split.length - 1];
        }
        return str == null ? 0 : str.length();
    }

    public static int removeDuplicates(int[] nums) {
        // [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(i, num);
            }
        }
        return map.values().size();
    }

    public static String addBinary(String a, String b) {
        int x = Integer.valueOf(a.trim(), 2);
        int y = Integer.valueOf(b.trim(), 2);
        return Integer.toBinaryString(x + y);
    }

    public static void main(String[] args) {
        int hello_world = lengthOfLastWord("Hello World");
        System.out.println(hello_world);
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        String s = addBinary("1010101010", "1010101");
        System.out.println(s);
        System.out.println(10 / 3 + 10 % 3);
        System.out.println((10 + 3 - 1) / 3);
    }
}
