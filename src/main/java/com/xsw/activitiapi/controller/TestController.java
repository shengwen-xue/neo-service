package com.xsw.activitiapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueshengwen
 * @since 2020/12/17 13:50
 */
@Api(tags = "test")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @ApiOperation(value = "首页")
    @GetMapping(value = "/index")
    public String index() {
        return "111";
    }
}
