package com.xsw.neo.service.mapper;

import com.xsw.neo.service.model.entity.Device;
import com.xsw.neo.service.model.entity.DeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    Integer batchSave(@Param("items") List<Device> devices);

    List<Device> listDevice(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    int count();
}