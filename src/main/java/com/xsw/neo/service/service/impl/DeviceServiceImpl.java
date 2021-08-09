package com.xsw.neo.service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.xsw.neo.service.mapper.DeviceMapper;
import com.xsw.neo.service.model.entity.Device;
import com.xsw.neo.service.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/7/30 15:12
 */
@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    public static final SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Integer batchSave() {
        long startTime = System.currentTimeMillis();
        List<Device> devices = Lists.newLinkedList();
        int count = 0;
        for (int i = 0; i < 20000; i++) {
            System.out.println("当前i:" + i);
            Device device = new Device();
            device.setName("设备" + i);
            device.setCode(generateCode());
            device.setAddress("上海莱佛士");
            device.setCheckUser("王德发");
            device.setCheckDate(new Date());
            device.setFixUser("马德发");
            device.setFixDate(new Date());
            device.setStatus(0);
            device.setIsDeleted(0);
            device.setArea("公共区域");
            device.setFloor("一楼");
            device.setUnit("一单元");
            device.setUptime(new Date());
            device.setUpData("解除告警类型: 01,电流值: 0.0A");
            device.setAlarmDate(new Date());
            device.setIsAlarm(0);
            device.setAlarmData("门开时长: 8s");
            device.setAlarmValue(1);
            device.setAlarmMessage("解除告警");
            devices.add(device);
            if (devices.size() >= 5000) {
                log.info("当前size为：{}", devices.size());
                log.info("开始入库....");
                count += deviceMapper.batchSave(devices);
                log.info("当前count：{}", count);
                log.info("结束入库....");

            }
        }
        if (devices.size() > 0) {
            log.info("最后入库的size为：{}", devices.size());
            count += deviceMapper.batchSave(devices);
            log.info("当前count：{}", count);
            log.info("结束入库....");
        }
        long endTime = System.currentTimeMillis();
        log.info("耗时：{}分钟", (endTime - startTime) / 1000000);
        return count;
    }

    @Override
    public PageInfo<Device> listDevice(int pageNum, int pageSize) {
        long startTime = System.currentTimeMillis();
        // Map<String, Object> map = Maps.newHashMap();

        PageHelper.startPage(pageNum, pageSize);
        List<Device> devices = deviceMapper.selectByExample(null);
        PageInfo<Device> devicePageInfo = new PageInfo<>(devices);

        // List<Device> devices = deviceMapper.listDevice(pageNum, pageSize);
        // int count = deviceMapper.count();
        // map.put("devices", devices);
        // map.put("count", count);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + ((endTime - startTime) / 1000) + "秒");
        return devicePageInfo;
    }

    @Override
    public PageInfo<Device> logicListDevice(int pageNum, int pageSize) {
        return null;
    }

    private String generateCode() {
        StringBuilder sb = new StringBuilder();
        int number = RandomUtils.nextInt(1, 3000000);
        String format = DeviceServiceImpl.format.format(new Date());
        return sb.append(format).append(number).toString();
    }
}