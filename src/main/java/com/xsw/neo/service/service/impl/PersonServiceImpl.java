package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.PersonMapper;
import com.xsw.neo.service.model.entity.Person;
import com.xsw.neo.service.model.entity.PersonExample;
import com.xsw.neo.service.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 人员服务类
 *
 * @author xueshengwen
 * @since 2021/7/16 14:14
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findPersonByName(String username) {
        PersonExample personExample = new PersonExample();
        personExample.createCriteria().andUsernameEqualTo(username);
        List<Person> personList = personMapper.selectByExample(personExample);
        if (CollectionUtils.isEmpty(personList)) {
            throw new CommonException(false, "未查询到该人员");
        }
        return personList.stream().findFirst().get();
    }
}
