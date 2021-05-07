package com.xsw.neo.service.simplecase;

import java.util.Scanner;

/**
 * @author xueshengwen
 * @since 2021/3/23 14:18
 */
public class Demo21 {

    public static void main(String[] args) {
        String password = "123456";
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= count; i++) {
            System.out.println("请输入密码:");
            String inStr = scanner.nextLine();
            if (inStr.equals(password)) {
                System.out.println("密码正确!门已开");
                break;
            } else {
                int x = count - i;
                System.err.println("密码错误!您还有" + x + "次机会！！！");
                if (x <= 0) {
                    System.out.println("系统已锁请联系管理员！！！");
                }
            }
        }
    }
}
