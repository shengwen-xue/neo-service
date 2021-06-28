package com.xsw.neo.service.config;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xueshengwen
 * @since 2021/6/25 17:46
 */
public class Demo {

    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
    }
}
