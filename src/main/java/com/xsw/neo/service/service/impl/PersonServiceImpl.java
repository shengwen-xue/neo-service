package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.model.entity.Person;
import com.xsw.neo.service.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 人员服务实现类
 *
 * @author xueshengwen
 * @since 2021/4/7 13:45
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer batchInsert() {
        Person person = new Person();
        int count = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            person.setName("Tom" + i);
            person.setAge(i);
            person.setSalary(new BigDecimal(i));
            person.setHobby("打游戏" + i);
            person.setAddress("上海第" + i + "弄");
            person.setSex(0);
            person.setTel("133333333" + i);
            person.setEmail(i + "@aliyun.com");
            person.setCreateTime(new Date());
            person.setUpdateTime(new Date());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return count;
    }
}
