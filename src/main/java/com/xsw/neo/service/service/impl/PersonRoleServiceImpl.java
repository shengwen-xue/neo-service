package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.PersonRoleMapper;
import com.xsw.neo.service.model.entity.PersonRole;
import com.xsw.neo.service.model.entity.PersonRoleExample;
import com.xsw.neo.service.service.PersonRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员角色关系类
 *
 * @author xueshengwen
 * @since 2021/7/16 14:38
 */
@Slf4j
@Service
public class PersonRoleServiceImpl implements PersonRoleService {

    @Autowired
    private PersonRoleMapper personRoleMapper;

    @Override
    public List<PersonRole> findPersonRolesById(Long personId) {
        PersonRoleExample personRoleExample = new PersonRoleExample();
        personRoleExample.createCriteria().andPersonIdEqualTo(personId);
        List<PersonRole> personRoles = personRoleMapper.selectByExample(personRoleExample);
        if (CollectionUtils.isEmpty(personRoles)) {
            throw new CommonException(false, "未查询到该人员对应的角色");
        }
        return personRoles;
    }
}
