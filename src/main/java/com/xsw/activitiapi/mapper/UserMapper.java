package com.xsw.activitiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户Mapper 接口
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<UserDTO> getUserInfo(@Param("userId") String userId);
}
