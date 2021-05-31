package com.xsw.neo.service.controller;

import com.google.common.collect.Maps;
import com.xsw.neo.service.model.convert.Context;
import com.xsw.neo.service.model.convert.PayContext;
import com.xsw.neo.service.service.Strategy;
import com.xsw.neo.service.service.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/5/24 14:15
 */
@Api(tags = "策略模式")
@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {

    @ApiOperation(value = "获取策略模式")
    @GetMapping(value = "/getStrategy")
    public void getStrategy() {
        FastStrategy fastStrategy = new FastStrategy();
        Context context = new Context(fastStrategy);
        context.contextInterface();
    }

    @ApiOperation(value = "获取策略模式")
    @GetMapping(value = "/pay")
    public void pay() {
        WeiXinPayService weiXinPayService = new WeiXinPayService();
        PayContext payContext = new PayContext(weiXinPayService);
        payContext.payResult();
    }

    @ApiOperation(value = "获取策略模式根据类型")
    @GetMapping(value = "/getStrategyByType")
    public void getStrategyByType(@RequestParam(value = "type") String type) {
        FastStrategy fastStrategy = new FastStrategy();
        NormalStrategy normalStrategy = new NormalStrategy();
        SlowStrategy slowStrategy = new SlowStrategy();
        SmoothStrategy smoothStrategy = new SmoothStrategy();

        Map<String, Strategy> map = Maps.newHashMap();
        map.put("FAST", fastStrategy);
        map.put("NORMAL", normalStrategy);
        map.put("SLOW", slowStrategy);
        map.put("SMOOTH", smoothStrategy);

        if (map.containsKey(type)) {
            Strategy strategy = map.get(type);
            strategy.run();
        }
    }
}
