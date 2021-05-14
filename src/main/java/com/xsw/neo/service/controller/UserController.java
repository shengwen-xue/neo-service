package com.xsw.neo.service.controller;

import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.model.entity.User;
import com.xsw.neo.service.model.param.UserQueryParam;
import com.xsw.neo.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author xueshengwen
 * @since 2020/12/18 13:29
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表")
    @PostMapping(value = "/listUser")
    public ResultBody listUser(@RequestBody UserQueryParam userQueryParam) {
        return ResultBody.SUCCESS(userService.listUser(userQueryParam));
    }

    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/saveUser")
    public ResultBody saveUser(@RequestBody User user) {
        return ResultBody.SUCCESS(userService.saveUser(user));
    }
}
