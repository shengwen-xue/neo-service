package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.enums.BusinessEnum;
import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.mapper.StudentMapper;
import com.xsw.neo.service.model.entity.Student;
import com.xsw.neo.service.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 学生服务接口类
 *
 * @author xueshengwen
 * @since 2021/5/12 16:56
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> listStudent() {
        return studentMapper.selectByExample(null);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveStudent(Student student) {
        Student dbStudent = studentMapper.selectByPrimaryKey(student.getId());
        if (Objects.nonNull(dbStudent)) {
            throw new CommonException(false, BusinessEnum.CANNOT_INSERT_THE_SAME_ID.getMessage());
        }
        return studentMapper.insertSelective(student);
    }

    @Override
    public Student findStudentInfo(Integer id) {
        return Optional.ofNullable(studentMapper.selectByPrimaryKey(id)).orElse(new Student());
    }
}
