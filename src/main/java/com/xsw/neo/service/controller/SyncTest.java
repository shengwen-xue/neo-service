package com.xsw.neo.service.controller;

/**
 * @author xueshengwen
 * @since 2021/6/9 9:46
 */
public class SyncTest {

    public synchronized void syncTest(Thread thread) {
        try {
            System.out.println("thread name:" + thread.getName() + "获取了锁。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread name:" + thread.getName() + "释放了锁。");
        }
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();

        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.syncTest(Thread.currentThread());
            }
        });

        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.syncTest(Thread.currentThread());
            }
        });

        thread1.start();
        thread2.start();
    }
}
