//package com.xsw.activitiapi.controller;
//
//import com.xsw.activitiapi.common.result.ResultBody;
//import com.xsw.activitiapi.service.PersonService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 人员控制器
// *
// * @author xueshengwen
// * @since 2021/4/7 13:41
// */
//@Api(tags = "人员相关接口")
//@RestController
//@RequestMapping(value = "/person")
//public class PersonController {
//
//    @Autowired
//    private PersonService personService;
//
//    @ApiOperation(value = "批量插入")
//    @GetMapping(value = "/batchInsert")
//    public ResultBody batchInsert() {
//        Integer flag = personService.batchInsert();
//        return ResultBody.SUCCESS("影响行数：" + flag);
//    }
//}
