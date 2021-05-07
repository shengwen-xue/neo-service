package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.common.enums.BusinessEnum;
import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.model.entity.Student;
import com.xsw.neo.service.model.vo.StudentVO;
import com.xsw.neo.service.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 学生服务实现类
 *
 * @author xueshengwen
 * @since 2021/3/4 11:58
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final List<Student> STUDENT_LIST = new LinkedList<>();

    static {
        for (int i = 0; i < 10; i++) {
            STUDENT_LIST.add(new Student("Tom" + i, 11 + i, "86+11" + i, "上海第" + i + "街道"));
        }
    }

    @Override
    public List<Student> listStudent() {
        return STUDENT_LIST;
    }

    @Override
    public StudentVO getStudent(String name) {
        if (StringUtils.isBlank(name)) {
            throw new CommonException(false, BusinessEnum.PARAMETER_IS_EMPTY.getMessage());
        }

        if (CollectionUtils.isEmpty(STUDENT_LIST)) {
            throw new CommonException(false, BusinessEnum.COLLECTION_IS_EMPTY.getMessage());
        }

        StudentVO studentVO = new StudentVO();

        for (Student student : STUDENT_LIST) {
            if (name.equals(student.getName())) {
                studentVO.setName(student.getName());
                studentVO.setAddr(student.getAddr());
            }
        }
        if (StringUtils.isBlank(studentVO.getName())) {
            throw new CommonException(false, BusinessEnum.NOT_FOUND_STUDENT.getMessage());
        }
        return studentVO;
    }
}
