package com.xsw.neo.service.demo;

/**
 * @author xueshengwen
 * @since 2021/6/4 17:15
 */
public class Demo10 {

    public static void main(String[] args) {
        Thread thread = new Thread("thread1");

        thread.start();

        thread.run();

        String name = thread.getName();

    }
}
