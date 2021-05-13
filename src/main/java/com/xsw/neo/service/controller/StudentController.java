package com.xsw.neo.service.controller;

import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 学生控制器
 *
 * @author xueshengwen
 * @since 2020/12/17 13:50
 */
@Api(tags = "学生相关接口")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "获取学生列表")
    @GetMapping(value = "/listStudent")
    public ResultBody listStudent() {
        return ResultBody.SUCCESS(studentService.listStudent());
    }
}
