package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.RolePermissionMapper;
import com.xsw.neo.service.model.entity.RolePermission;
import com.xsw.neo.service.model.entity.RolePermissionExample;
import com.xsw.neo.service.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限关系类
 *
 * @author xueshengwen
 * @since 2021/7/16 15:13
 */
@Slf4j
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> findRolePermissionsByid(Long roleId) {
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        if (CollectionUtils.isEmpty(rolePermissions)) {
            throw new CommonException(false, "未查询到该角色对应的权限");
        }
        return rolePermissions;
    }
}
