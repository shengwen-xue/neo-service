package com.xsw.neo.service.demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author xueshengwen
 * @since 2021/5/27 15:41
 */
public class Demo7 {

    public static void main(String[] args) {

        int itemCount = 1000;

        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>(itemCount - 100);

        System.out.println("init size: " + concurrentHashMap.size());

        try {
            ForkJoinPool forkJoinPool = new ForkJoinPool(10);

            forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
                int num = itemCount - concurrentHashMap.size();
                System.out.println("num size: " + num);
                concurrentHashMap.put("num", num);
            }));

            forkJoinPool.shutdown();
            forkJoinPool.awaitTermination(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("final size: " + concurrentHashMap.size());

    }
}
