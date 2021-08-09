package com.xsw.neo.service.service;

import com.github.pagehelper.PageInfo;
import com.xsw.neo.service.model.entity.Device;

/**
 * @author xueshengwen
 * @since 2021/7/30 15:11
 */
public interface DeviceService {

    Integer batchSave();

    PageInfo<Device> listDevice(int pageNum, int pageSize);

    PageInfo<Device> logicListDevice(int pageNum, int pageSize);
}
