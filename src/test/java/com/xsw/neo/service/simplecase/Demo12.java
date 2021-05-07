package com.xsw.neo.service.simplecase;

import cn.hutool.core.lang.Console;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/2/2 13:39
 */
public class Demo12 {

    public static void main(String[] args) throws IOException {

        File file = new File("C:/mtn/783e4ef71d8b4b31a32cad87d2a8f401.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str = "";
        int line = 1;
        List<String> strings = new ArrayList<>();
        BufferedWriter writer = null;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println("第" + line + "行:" + str);
            String substring = str.substring(0, str.indexOf("||"));
            System.out.println(substring);
            File file1 = new File("C:/mtn/1.txt");
            writer = new BufferedWriter(new FileWriter(file1.getPath(), true));
            writer.write(substring + "\n");
            writer.flush();

            substring = "('" + substring + "')";
            strings.add(substring);
            line++;
        }
        System.out.println(strings.toString());
        Console.log(strings.size());
    }
}
