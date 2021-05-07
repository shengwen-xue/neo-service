package com.xsw.activitiapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.model.entity.User;
import com.xsw.activitiapi.service.UserService;
import com.xsw.activitiapi.utils.Test;
import com.xsw.activitiapi.utils.TestUtils;
import com.xsw.activitiapi.utils.TestUtils2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Test test;

    @Override
    public List<UserDTO> getUserInfo(String userId) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", userId);
//        List<User> userList = userMapper.selectList(queryWrapper);
//        return userList.stream().map(user -> {
//            UserDTO userDTO = new UserDTO();
//            BeanUtils.copyProperties(user, userDTO);
//            return userDTO;
//        }).collect(Collectors.toList());
        return null;
    }

    @Override
    public String test1() {
        return TestUtils.init();
    }

    @Override
    public String test2() {
        return TestUtils2.init();
    }

    @Override
    public String test3() {
        return test.test();
    }
}
