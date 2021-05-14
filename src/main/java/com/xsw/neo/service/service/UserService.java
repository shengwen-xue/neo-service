package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.User;
import com.xsw.neo.service.model.param.UserQueryParam;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
public interface UserService {

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    List<User> listUser(UserQueryParam userQueryParam);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 影响行数
     */
    Integer saveUser(User user);
}
