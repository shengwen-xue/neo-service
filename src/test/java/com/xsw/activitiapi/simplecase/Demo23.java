package com.xsw.activitiapi.simplecase;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @author xueshengwen
 * @since 2021/4/1 13:40
 */
public class Demo23 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("张三");
        FutureTask<String> stringFutureTask = new FutureTask<>(myThread);
        Thread thread = new Thread(stringFutureTask);
        thread.run();
    }
}

class MyThread implements Callable<String> {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return "name:" + name;
    }
}
