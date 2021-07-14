package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.enums.BusinessEnum;
import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.UserMapper;
import com.xsw.neo.service.model.dto.UserDTO;
import com.xsw.neo.service.model.entity.User;
import com.xsw.neo.service.model.entity.UserExample;
import com.xsw.neo.service.model.param.UserQueryParam;
import com.xsw.neo.service.service.UserService;
import com.xsw.neo.service.utils.PhoneNumberUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<User> listUser(UserQueryParam userQueryParam) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if (StringUtils.isNotBlank(userQueryParam.getUsername())) {
            criteria.andUsernameLike("%" + userQueryParam.getUsername() + "%");
        }

        if (StringUtils.isNotBlank(userQueryParam.getTel())) {
            criteria.andTelLike("%" + userQueryParam.getTel() + "%");
        }

        List<User> users = userMapper.selectByExample(userExample);

        return users.stream().map(u -> {
            User user = new User();
            user.setId(u.getId());
            user.setUsername(u.getUsername());
            user.setPassword(u.getPassword().replaceAll(u.getPassword(), "******"));
            user.setTel(PhoneNumberUtils.blurPhone(u.getTel()));
            return user;
        }).collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveUser(UserDTO userDTO) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userDTO.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isNotEmpty(users)) {
            throw new CommonException(false, BusinessEnum.ALREADY_EXISTS.getMessage());
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setTel(userDTO.getTel());
        return userMapper.insertSelective(user);
    }
}
