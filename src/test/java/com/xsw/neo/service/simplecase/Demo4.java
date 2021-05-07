package com.xsw.neo.service.simplecase;

import java.util.ArrayList;
import java.util.List;

/**
 * 性能测试
 *
 * @author xueshengwen
 * @since 2020/12/22 13:40
 */
public class Demo4 {

    private static void test1() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
        long endTime = System.nanoTime();
        System.out.println("[test1]:外大内小耗时：" + (endTime - startTime));
    }

    private static void test2() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10000000; j++) {

            }
        }
        long endTime = System.nanoTime();
        System.out.println("[test2]:外小内大耗时：" + (endTime - startTime));
    }

    private static void test3() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            int a = 10;
            int b = 20;
            i = i * a * b;
        }
        long endTime = System.nanoTime();
        System.out.println("[test3]:未提取耗时：" + (endTime - startTime));
    }

    private static void test4() {
        int a = 10;
        int b = 20;
        int c = a * b;
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            i = i * c;
        }
        long endTime = System.nanoTime();
        System.out.println("[test4]:已提取耗时：" + (endTime - startTime));
    }

    private static void test5() {
        long startTime = System.nanoTime();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {

        }
        long endTime = System.nanoTime();
        System.out.println("[test5]:未优化集合耗时：" + (endTime - startTime));
    }

    private static void test6() {
        long startTime = System.nanoTime();
        List<Integer> numberList = new ArrayList<>();
        int size = numberList.size();
        for (int i = 0; i < size; i++) {

        }
        long endTime = System.nanoTime();
        System.out.println("[test6]:优化后的集合耗时：" + (endTime - startTime));
    }

    private static void test7() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        System.out.println("[test7]:在内部捕获异常耗时：" + (endTime - startTime));
    }

    private static void test8() {
        long startTime = System.nanoTime();
        try {
            for (int i = 0; i < 10000000; i++) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("[test8]:在外部捕获异常耗时：" + (endTime - startTime));
    }

    private static void test9() {
        System.out.println(0xa << 2);
    }

    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        test1();
        test2();
        System.out.println("----------------------------------------");
        test3();
        test4();
        System.out.println("----------------------------------------");
        test5();
        test6();
        System.out.println("----------------------------------------");
        test7();
        test8();
        System.out.println("----------------------------------------");

        test9();
    }
}
