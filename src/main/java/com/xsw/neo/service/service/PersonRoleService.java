package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.PersonRole;

import java.util.List;

/**
 * 人员角色关系接口
 *
 * @author xueshengwen
 * @since 2021/7/16 14:36
 */
public interface PersonRoleService {

    List<PersonRole> findPersonRolesById(Long personId);
}
