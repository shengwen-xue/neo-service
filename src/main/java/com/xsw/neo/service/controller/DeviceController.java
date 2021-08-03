package com.xsw.neo.service.controller;

import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueshengwen
 * @since 2021/7/30 14:53
 */
@Api(tags = "设备控制器:测试300W数据")
@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value = "批量生成300W数据")
    @GetMapping(value = "/batchSave")
    public ResultBody batchSave() {
        return ResultBody.SUCCESS(deviceService.batchSave());
    }
}
