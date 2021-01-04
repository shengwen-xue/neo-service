package com.xsw.activitiapi.simplecase;

/**
 * core Java
 *
 * @author xueshengwen
 * @since 2020/12/24 11:09
 */
public class Demo6 {
    public static void main(String[] args) {
        // && 表达式左右两边但凡有一个是false就直接返回false
        // || 表达式左右两边但凡有一个是true就直接返回true
        // &  表达式左边为true 还要计算右边
        testShort();
    }

    private static void testShort() {
        int a = 10, b = 5;
        if (a < b & b > 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
