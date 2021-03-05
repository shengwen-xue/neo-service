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

    List<Student> listStudent();

    StudentVO getStudent(String name);
}
