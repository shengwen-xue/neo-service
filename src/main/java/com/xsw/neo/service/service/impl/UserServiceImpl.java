package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.enums.BusinessEnum;
import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.UserMapper;
import com.xsw.neo.service.model.entity.User;
import com.xsw.neo.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 用户服务接口类
 *
 * @author xueshengwen
 * @since 2021/5/12 16:56
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.selectByExample(null);
    }

    @Override
    public Integer saveUser(User user) {
        User dbUser = userMapper.selectByPrimaryKey(user.getId());
        if (Objects.nonNull(dbUser)) {
            throw new CommonException(false, BusinessEnum.CANNOT_INSERT_THE_SAME_ID.getMessage());
        }
        return userMapper.insertSelective(user);
    }
}
