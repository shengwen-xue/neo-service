package com.xsw.neo.service.controller;

import com.xsw.neo.service.service.XxlJobDemoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xxlJob定时任务相关接口
 *
 * @author xueshengwen
 * @since 2021/6/9 14:05
 */
@Api(tags = "xxlJob定时任务相关接口")
@RestController
@RequestMapping(value = "/xxlJob")
public class XxlJobDemoController {

    @Autowired
    private XxlJobDemoService xxlJobDemoService;


}
