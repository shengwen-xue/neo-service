package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.Permission;

import java.util.List;

/**
 * 权限服务接口
 *
 * @author xueshengwen
 * @since 2021/7/16 15:03
 */
public interface PermissionService {

    List<Permission> findPermissionsByName(String username);
}
