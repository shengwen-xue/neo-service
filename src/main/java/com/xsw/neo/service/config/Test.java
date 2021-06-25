package com.xsw.neo.service.config;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xueshengwen
 * @since 2021/6/24 17:51
 */
public class Test {

    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        while (true) {
            if (queue.isEmpty()) {
                System.out.println("队列为空");
                break;
            } else {
                String poll = queue.poll();
                System.out.println("queue value:" + poll);
            }
        }

    }
}
