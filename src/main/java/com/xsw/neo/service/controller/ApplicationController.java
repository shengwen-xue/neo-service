package com.xsw.neo.service.controller;

import com.google.common.collect.Maps;
import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.config.ApplicationConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 用于获取自定义配置文件的配置 两种方式
 *
 * @author xueshengwen
 * @since 2021/7/13 11:29
 */
@Api(tags = "获取自定义配置文件的配置")
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Value(value = "${service.logUrl}")
    public String logUrl;

    @Value(value = "${service.loginUrl}")
    public String loginUrl;

    @Value(value = "${service.logOutUrl}")
    public String logOutUrl;

    @GetMapping(value = "/getApplication")
    @ApiOperation(value = "获取自定义配置文件的配置方式一")
    public ResultBody getApplication() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("logUrl", logUrl);
        map.put("loginUrl", loginUrl);
        map.put("logOutUrl", logOutUrl);
        return ResultBody.SUCCESS(map);
    }

    @Autowired
    private ApplicationConfig applicationConfig;

    @GetMapping(value = "/application")
    @ApiOperation(value = "/获取自定义配置文件的配置方式二")
    public ResultBody application() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("logUrl", applicationConfig.getLogUrl());
        map.put("loginUrl", applicationConfig.getLoginUrl());
        map.put("logOutUrl", applicationConfig.getLogOutUrl());
        return ResultBody.SUCCESS(map);
    }

}
