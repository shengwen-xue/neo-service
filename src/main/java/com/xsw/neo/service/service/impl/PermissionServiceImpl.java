package com.xsw.neo.service.service.impl;

import com.google.common.collect.Lists;
import com.xsw.neo.service.mapper.PermissionMapper;
import com.xsw.neo.service.model.entity.Permission;
import com.xsw.neo.service.model.entity.Role;
import com.xsw.neo.service.model.entity.RolePermission;
import com.xsw.neo.service.service.PermissionService;
import com.xsw.neo.service.service.RolePermissionService;
import com.xsw.neo.service.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限服务类
 *
 * @author xueshengwen
 * @since 2021/7/16 15:04
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissionsByName(String username) {
        List<Role> roleList = roleService.findRolesByName(username);
        List<Long> roleIdList = roleList.stream().map(Role::getId).collect(Collectors.toList());

        List<Long> permissionIdList = Lists.newLinkedList();
        roleIdList.forEach(roleId->{
            List<RolePermission> rolePermissionList = rolePermissionService.findRolePermissionsByid(roleId);
            List<Long> permissionIds = rolePermissionList.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
            permissionIds.forEach(permissionId->{
                permissionIdList.add(permissionId);
            });
        });
        // 权限id集合去重
        List<Long> collect = permissionIdList.stream().distinct().collect(Collectors.toList());

        List<Permission> permissionList = Lists.newLinkedList();
        for (Long permissionId : collect) {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
            permissionList.add(permission);
        }
        return permissionList;
    }
}
