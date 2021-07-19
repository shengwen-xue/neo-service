package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.Role;

import java.util.List;

/**
 * 角色服务接口
 *
 * @author xueshengwen
 * @since 2021/7/16 14:24
 */
public interface RoleService {

    List<Role> findRolesByName(String username);
}
