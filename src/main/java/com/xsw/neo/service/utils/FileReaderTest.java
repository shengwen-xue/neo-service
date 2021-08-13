package com.xsw.neo.service.utils;

import java.io.FileInputStream;
import java.io.FileReader;

/**
 * @author xueshengwen
 * @since 2021/8/12 16:20
 */
public class FileReaderTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\data\\q.txt");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        FileReader fileReader = new FileReader("D:\\data\\q.txt");
        char[] chars = new char[1024];
        while((len = fileReader.read(chars)) != -1){
            System.out.println(chars);
        }

        // java.io.FileNotFoundException: D:\data\q111.txt (系统找不到指定的文件。)
        // FileReader fileReader1 = new FileReader("D:\\data\\q111.txt");

        fileInputStream.close();
        fileReader.close();
        // fileReader1.close();
    }
}
