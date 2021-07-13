package com.xsw.neo.service.controller;

import com.google.common.collect.Maps;
import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.config.ApplicationConfig;
import com.xsw.neo.service.model.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "获取自定义配置文件的配置方式二")
    public ResultBody application() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("logUrl", applicationConfig.getLogUrl());
        map.put("loginUrl", applicationConfig.getLoginUrl());
        map.put("logOutUrl", applicationConfig.getLogOutUrl());
        return ResultBody.SUCCESS(map);
    }

    @GetMapping(value = "/getUrlParams/{username}/{age}")
    @ApiOperation(value = "获取请求地址参数")
    public String getUrlParams(@PathVariable(value = "username")
                               @ApiParam(name = "name", value = "用户名", required = true) String name,
                               @PathVariable(value = "age")
                               @ApiParam(name = "age", value = "年龄", required = true) Integer age) {
        // 使用restful风格的请求地址 参数需要加上@PathVariable注解 value值和请求的地址参数对应
        // 如果想要实现请求参数字段和接收参数字段不一致  不管接收参数是什么 请求参数和@PathVariable的value对应上
        return "获取参数成功：username：" + name + " age：" + age;
    }

    @GetMapping(value = "/getUrlParams")
    @ApiOperation(value = "获取请求地址参数")
    public String getUrlParam(@RequestParam(value = "username")
                              @ApiParam(name = "username", value = "用户名", required = true) String name,
                              @RequestParam(value = "password", required = false)
                              @ApiParam(name = "password", value = "密码") String password) {
        return "获取参数成功：username：" + name + " password：" + password;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "模拟表单登录")
    public String login(User user) {
        // 测试通过postman form-data登录 不使用@RequestBody的区别
        // 使用表单登录可以不写@RequestBody注解 但是要是使用json格式必须写该注解 不然接收不到参数
        String username = user.getUsername();
        String password = user.getPassword();
        return "登录成功：用户名：" + username + " 密码：" + password;
    }
}
