package com.xsw.neo.service.mapper;

import com.xsw.neo.service.model.entity.Sensor;
import com.xsw.neo.service.model.entity.SensorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorMapper {
    long countByExample(SensorExample example);

    int deleteByExample(SensorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    List<Sensor> selectByExample(SensorExample example);

    Sensor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByExample(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
}