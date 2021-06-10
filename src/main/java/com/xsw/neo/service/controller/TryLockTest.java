package com.xsw.neo.service.controller;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xueshengwen
 * @since 2021/6/8 15:03
 */
public class TryLockTest {

    private Lock lock = new ReentrantLock();

    private int count = 0;

    public void test(Thread thread) throws InterruptedException {
        // 获取锁
        //lock.lock();

        if (lock.tryLock(2, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println("thread name:" + thread.getName() + "获取了锁。");
                System.out.println("thread name:" + thread.getName() + "操作的count=" + count);
                count++;
                //Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("thread name:" + thread.getName() + "操作后的count=" + count);
                System.out.println("thread name:" + thread.getName() + "释放了锁。");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        TryLockTest lockTest = new TryLockTest();

        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lockTest.test(Thread.currentThread());

            }
        });

        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lockTest.test(Thread.currentThread());

            }
        });

        // 线程3
        Thread thread3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                lockTest.test(Thread.currentThread());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}



