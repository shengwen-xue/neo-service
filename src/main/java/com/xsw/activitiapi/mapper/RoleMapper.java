package com.xsw.activitiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.model.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
