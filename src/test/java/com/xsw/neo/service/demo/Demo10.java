package com.xsw.neo.service.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/**
 * 多线程的四种实现方式
 *
 * @author xueshengwen
 * @since 2021/6/4 17:15
 */
public class Demo10 {

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        RunnableDemo runnableDemo = new RunnableDemo();
        runnableDemo.run();

        CallableDemo callableDemo = new CallableDemo();
        String call = callableDemo.call();
        System.out.println(call);

        ExecutorDemo executorDemo = new ExecutorDemo();
        executorDemo.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}

class ThreadDemo extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t=" + i +
                    ",Id:" + this.getId() +
                    ",Name:" + this.getName() +
                    ",currentThreadName:" + Thread.currentThread().getName());

        }
    }
}

class RunnableDemo implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("r=" + i +
                    ",SimpleName:" + this.getClass().getSimpleName() +
                    ",Name:" + this.getClass().getName() +
                    ",TypeName:" + this.getClass().getTypeName() +
                    ",CanonicalName:" + this.getClass().getCanonicalName() +
                    ",currentThreadName:" + Thread.currentThread().getName());
        }
    }
}

class CallableDemo implements Callable<String> {

    @Override
    public String call() {

        for (int i = 0; i < 5; i++) {
            System.out.println("c=" + i +
                    ",SimpleName:" + this.getClass().getSimpleName() +
                    ",Name:" + this.getClass().getName() +
                    ",TypeName:" + this.getClass().getTypeName() +
                    ",CanonicalName:" + this.getClass().getCanonicalName() +
                    ",currentThreadName:" + Thread.currentThread().getName());
        }
        return "SUCCESS";
    }
}

class ExecutorDemo implements Executor {

    @Override
    public void execute(Runnable command) {
        for (int i = 0; i < 5; i++) {
            System.out.println("e:" + i + ",currentThreadName:" + Thread.currentThread().getName());
        }
    }
}
