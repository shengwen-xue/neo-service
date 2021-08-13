package com.xsw.neo.service.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author xueshengwen
 * @since 2021/8/12 14:44
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\data\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);

        FileOutputStream fileOutputStream1 = new FileOutputStream("D:\\data\\b.txt");

        byte[] bytes = {97, 98, 99, 100, 101, 102};
        fileOutputStream1.write(bytes);

        fileOutputStream.write(bytes, 1, 4);

        for (byte b : bytes) {
            fileOutputStream1.write(b);
            fileOutputStream1.write("\r\n".getBytes());
        }

        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
