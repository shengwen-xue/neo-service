package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.Strategy;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:12
 */
public class SlowStrategy implements Strategy {


    @Override
    public void run() {
        // 慢速执行逻辑
        System.out.println("慢速执行逻辑");
    }
}
