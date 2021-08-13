package com.xsw.neo.service.utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author xueshengwen
 * @since 2021/8/12 15:02
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\data\\1.txt");
        FileInputStream fileInputStream1 = new FileInputStream("D:\\data\\2.txt");
        FileInputStream fileInputStream2 = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\images\\QQ图片20201126133433.jpg");
        FileOutputStream fileOutputStream2 = new FileOutputStream("D:\\data\\1.jpg");

        // FileInputStream 单字节读
        int read, read1, read2 = 0;
        while ((read = fileInputStream.read()) != -1) {
            System.out.print(read);
            System.out.println(" : " + (char) read);
        }

        System.out.println("-------分割线");


//        while ((read1 = fileInputStream1.read()) != -1) {
//            System.out.print(read1);
//            System.out.println(" : " + (char) read1);
//        }
//
//        System.out.println("-------分割线");

        // FileInputStream 字节数组读
//        byte[] bytes = new byte[100];
//
//        while ((read2 = fileInputStream1.read(bytes)) != -1) {
//            System.out.print(read2);
//            System.out.println(" : " + new String(bytes));
//        }

        byte[] bytes1 = new byte[3];
        int len = 0;
        while ((len = fileInputStream1.read(bytes1)) != -1) {
            System.out.print(new String(bytes1, 0, len));
        }
        System.out.println();

        // 复制图片到指定文件下
        byte[] bytes2 = new byte[1024];
        while ((read = fileInputStream2.read(bytes2)) != -1) {
            fileOutputStream2.write(bytes2, 0, bytes2.length);
        }
        System.out.println("复制成功！");

        fileInputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream2.close();
    }
}
