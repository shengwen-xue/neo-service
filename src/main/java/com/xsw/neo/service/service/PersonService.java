package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.Person;

/**
 * 人员服务接口
 *
 * @author xueshengwen
 * @since 2021/7/16 14:13
 */
public interface PersonService {

    Person findPersonByName(String username);
}
