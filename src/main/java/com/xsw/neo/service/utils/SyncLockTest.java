package com.xsw.neo.service.utils;

/**
 * @author xueshengwen
 * @since 2021/6/9 9:46
 */
public class SyncLockTest {

    private Integer count = 0;

    public synchronized void syncTest(Thread thread) {
        try {
            System.out.println("thread name:" + thread.getName() + "获取了锁。");
            System.out.println("thread name:" + thread.getName() + "操作的count=" + count);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread name:" + thread.getName() + "操作后的count=" + count);
            System.out.println("thread name:" + thread.getName() + "释放了锁。");
        }
    }

    public static void main(String[] args) {
        SyncLockTest syncLockTest = new SyncLockTest();

        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncLockTest.syncTest(Thread.currentThread());
            }
        });

        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncLockTest.syncTest(Thread.currentThread());
            }
        });

        thread1.start();
        thread2.start();
    }
}
