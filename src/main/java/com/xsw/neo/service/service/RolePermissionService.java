package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.RolePermission;

import java.util.List;

/**
 * 角色权限服务接口
 *
 * @author xueshengwen
 * @since 2021/7/16 15:12
 */
public interface RolePermissionService {

    List<RolePermission> findRolePermissionsByid(Long roleId);
}
