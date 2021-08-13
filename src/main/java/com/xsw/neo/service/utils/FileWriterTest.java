package com.xsw.neo.service.utils;

import java.io.FileWriter;

/**
 * @author xueshengwen
 * @since 2021/8/12 15:50
 */
public class FileWriterTest {

    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("D:\\data\\w.txt");

        fileWriter.write(97);
        fileWriter.write(100);
        fileWriter.write(97);
        fileWriter.write(97);
        fileWriter.write("666");

        fileWriter.close();
    }
}
