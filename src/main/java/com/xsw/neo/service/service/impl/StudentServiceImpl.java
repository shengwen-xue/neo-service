package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.mapper.StudentMapper;
import com.xsw.neo.service.model.entity.Student;
import com.xsw.neo.service.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/5/12 16:56
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> listStudent() {
        List<Student> students = studentMapper.selectByExample(null);
        return students;
    }
}
