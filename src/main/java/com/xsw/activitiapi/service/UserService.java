package com.xsw.activitiapi.service;

import com.xsw.activitiapi.model.dto.UserDTO;

import java.util.List;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
public interface UserService {

    List<UserDTO> getUserInfo(String userId);
}
