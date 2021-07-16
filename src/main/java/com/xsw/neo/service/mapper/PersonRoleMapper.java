package com.xsw.neo.service.mapper;

import com.xsw.neo.service.model.entity.PersonRole;
import com.xsw.neo.service.model.entity.PersonRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonRoleMapper {
    long countByExample(PersonRoleExample example);

    int deleteByExample(PersonRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonRole record);

    int insertSelective(PersonRole record);

    List<PersonRole> selectByExample(PersonRoleExample example);

    PersonRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);

    int updateByExample(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);

    int updateByPrimaryKeySelective(PersonRole record);

    int updateByPrimaryKey(PersonRole record);
}