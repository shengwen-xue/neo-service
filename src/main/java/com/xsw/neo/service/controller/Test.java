package com.xsw.neo.service.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xueshengwen
 * @since 2021/6/8 15:03
 */
public class Test {

    int count = 0;

    void getCount() {
        System.out.println(Thread.currentThread().getName() + "-> getCount=" + count++);
    }


    public static void main(String[] args) {

        Test test = new Test();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    test.getCount();
                }
            });
        }
    }
}



