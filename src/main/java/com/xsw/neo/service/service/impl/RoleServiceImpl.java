package com.xsw.neo.service.service.impl;

import com.google.common.collect.Lists;
import com.xsw.neo.service.mapper.RoleMapper;
import com.xsw.neo.service.model.entity.Person;
import com.xsw.neo.service.model.entity.PersonRole;
import com.xsw.neo.service.model.entity.Role;
import com.xsw.neo.service.service.PersonRoleService;
import com.xsw.neo.service.service.PersonService;
import com.xsw.neo.service.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色服务类
 *
 * @author xueshengwen
 * @since 2021/7/16 14:25
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRoleService personRoleService;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRolesByName(String username) {
        Person person = personService.findPersonByName(username);
        List<PersonRole> personRoles = personRoleService.findPersonRolesById(person.getId());
        List<Long> roleIds = personRoles.stream().map(PersonRole::getRoleId).collect(Collectors.toList());

        List<Role> roleList = Lists.newLinkedList();
        for (Long roleId : roleIds) {
            Role role = roleMapper.selectByPrimaryKey(roleId);
            roleList.add(role);
        }
        return roleList;
    }
}
