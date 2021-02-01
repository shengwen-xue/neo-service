package com.xsw.activitiapi.simplecase;

import lombok.var;

import java.io.*;

/**
 * @author xueshengwen
 * @since 2021/1/29 13:55
 */
public class Demo10 {

    public static void main(String[] args) throws IOException {
        int i = 2147483647;
        int i2 = -2147483648;
        int x = 12345 / 67;
        int y = 12345 % 67;
        File file = new File("D:\\1.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
//        bufferedOutputStream.write(file.getBytes());
        var sb = new BufferedOutputStream(new FileOutputStream(file));
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(bufferedOutputStream.getClass());
        System.out.println(sb.getClass());
        System.out.println(x);
        System.out.println(y);
        String s3 = "中文 ABC";
        System.out.println(s3.getBytes().length);
    }
}
