package com.xsw.neo.service.service;

import com.xsw.neo.service.model.entity.Student;

import java.util.List;

/**
 * 学生服务接口
 *
 * @author xueshengwen
 * @since 2021/3/4 11:58
 */
public interface StudentService {

    /**
     * 获取学生列表
     *
     * @return 学生列表
     */
    List<Student> listStudent();
}
