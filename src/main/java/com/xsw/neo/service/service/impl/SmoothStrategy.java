package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.Strategy;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:11
 */
public class SmoothStrategy implements Strategy {


    @Override
    public void run() {
        // 平滑执行逻辑
        System.out.println("平滑执行逻辑");
    }
}
