package com.xsw.neo.service.service;

import com.github.pagehelper.PageInfo;
import com.xsw.neo.service.model.entity.Device;

import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/7/30 15:11
 */
public interface DeviceService {

    Integer batchSave();

    Map<String, Object> listDevice(int pageNum, int pageSize);
}
