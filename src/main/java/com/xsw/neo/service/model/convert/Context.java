package com.xsw.neo.service.model.convert;

import com.xsw.neo.service.service.Strategy;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:20
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.run();
    }
}
