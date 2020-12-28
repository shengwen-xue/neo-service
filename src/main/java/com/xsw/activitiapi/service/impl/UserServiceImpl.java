package com.xsw.activitiapi.service.impl;

import com.xsw.activitiapi.mapper.UserMapper;
import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getUserInfo(String userId) {
        return userMapper.getUserInfo(userId);
    }
}
