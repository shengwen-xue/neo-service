package com.xsw.activitiapi.simplecase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xueshengwen
 * @since 2021/2/1 14:08
 */
public class Demo11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = scanner.nextLine();
        System.out.println("请输入年龄:");
        int age = scanner.nextInt();
        System.out.printf("姓名: %s, 年龄: %d\n", name, age);

        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前:
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] < ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }

        // 排序后:
        System.out.println(Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }

        int[][] ns1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] arr0 = ns1[0];
        System.out.println(Arrays.deepToString(ns1));

        int[][][] ns2 = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };
        int sum = 0;
        for (int[] ints : ns1) {
            for (int i : ints) {
                sum += i;
                i++;
            }
        }
        System.out.println(sum / ns.length);
        System.out.println(Arrays.deepToString(ns1));
    }
}