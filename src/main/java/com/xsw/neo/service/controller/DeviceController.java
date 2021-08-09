package com.xsw.neo.service.controller;

import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ApiOperation(value = "分页设备列表")
    @GetMapping(value = "/listDevice")
    public ResultBody listDevice(@RequestParam(value = "pageNum", required = false)
                                 @ApiParam(value = "起始页", name = "pageNum", required = true) int pageNum,
                                 @RequestParam(value = "pageSize", required = false)
                                 @ApiParam(value = "页大小", name = "pageSize", required = true) int pageSize) {
        return ResultBody.SUCCESS(deviceService.listDevice(pageNum, pageSize));
    }

    @ApiOperation(value = "逻辑分页设备列表")
    @GetMapping(value = "/logicListDevice")
    public ResultBody logicListDevice(@RequestParam(value = "pageNum", required = false)
                                 @ApiParam(value = "起始页", name = "pageNum", required = true) int pageNum,
                                 @RequestParam(value = "pageSize", required = false)
                                 @ApiParam(value = "页大小", name = "pageSize", required = true) int pageSize) {
        return ResultBody.SUCCESS(deviceService.logicListDevice(pageNum, pageSize));
    }
}
