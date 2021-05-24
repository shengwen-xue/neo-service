package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.Strategy;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:10
 */
public class FastStrategy implements Strategy {


    @Override
    public void run() {
        // 快速执行逻辑
        System.out.println("快速执行逻辑");
    }
}
