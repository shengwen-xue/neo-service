package com.xsw.activitiapi.controller;

import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户信息")
    @GetMapping(value = "/userInfo/{userId}")
    public List<UserDTO> userInfo(@ApiParam(name = "userId", value = "用户ID", required = true)
                                  @PathVariable String userId) {
        return userService.getUserInfo(userId);
    }

    @ApiOperation(value = "测试1")
    @GetMapping(value = "/test1")
    public String test1() {
        return userService.test1();
    }

    @ApiOperation(value = "测试2")
    @GetMapping(value = "/test2")
    public String test2() {
        return userService.test2();
    }

    @ApiOperation(value = "测试3")
    @GetMapping(value = "/test3")
    public String test3() {
        return userService.test3();
    }
}
