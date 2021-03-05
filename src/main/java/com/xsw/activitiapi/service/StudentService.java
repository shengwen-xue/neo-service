package com.xsw.activitiapi.service;

import com.xsw.activitiapi.model.entity.Student;
import com.xsw.activitiapi.model.vo.StudentVO;

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

    /**
     * 获取学生信息
     *
     * @param name 姓名
     * @return 学生VO
     */
    StudentVO getStudent(String name);
}
