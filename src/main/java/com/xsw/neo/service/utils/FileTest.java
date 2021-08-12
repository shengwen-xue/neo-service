package com.xsw.neo.service.utils;

import java.io.File;

/**
 * @author xueshengwen
 * @since 2021/8/12 14:05
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("D:\\my-doc");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        File parentFile = file.getParentFile();
        String absolutePath1 = parentFile.getAbsolutePath();
        System.out.println(absolutePath1);

        String parent = file.getParent();
        String name = file.getName();
        String path = file.getPath();
        System.out.format("parent: %s, name: %s, path: %s %n", parent, name, path);

        long lastModified = file.lastModified();
        long length = file.length();
        String[] list = file.list();
        File[] files = file.listFiles();

        System.out.println("lastModified: " + lastModified + ", length: " + length);
        System.out.println("========================");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("========================");
        for (File file1 : files) {
            System.out.println(file1.getName());
        }
    }
}
