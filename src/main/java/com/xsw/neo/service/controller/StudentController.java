package com.xsw.neo.service.controller;

import com.google.common.collect.Lists;
import com.xsw.neo.service.common.annotation.ExportAnnotation;
import com.xsw.neo.service.common.annotation.I18nAnnotation;
import com.xsw.neo.service.common.annotation.LogAnnotation;
import com.xsw.neo.service.common.result.ResultBody;
import com.xsw.neo.service.model.bo.StudentBO;
import com.xsw.neo.service.model.dto.StudentDTO;
import com.xsw.neo.service.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 学生控制器
 *
 * @author xueshengwen
 * @since 2020/12/17 13:50
 */
@Api(tags = "学生相关接口")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "学生列表")
    @GetMapping(value = "/listStudent")
    @LogAnnotation
    public ResultBody listStudent() {
        return ResultBody.SUCCESS(studentService.listStudent());
    }

    @ApiOperation(value = "新增学生")
    @PostMapping(value = "/saveStudent")
    public ResultBody saveStudent(@RequestBody StudentDTO studentDTO) {
        return ResultBody.SUCCESS(studentService.saveStudent(studentDTO));
    }

    @ApiOperation(value = "获取学生信息")
    @GetMapping(value = "/findStudentInfo")
    public ResultBody findStudentInfo(@RequestParam(value = "id") Integer id) {
        return ResultBody.SUCCESS(studentService.findStudentInfo(id));
    }

    @ApiOperation(value = "导出Excel 测试多语言切换")
    @GetMapping(value = "/export")
    @ExportAnnotation
    public void export() throws Exception {

        // 模拟查询的学生列表
        List<StudentBO> studentBOList = Lists.newArrayList();
        studentBOList.add(new StudentBO("薛胜文", "申城佳苑", "男"));
        studentBOList.add(new StudentBO("罗彦凯", "开天公寓", "男"));
        studentBOList.add(new StudentBO("王彬", "浦江镇", "男"));
        studentBOList.add(new StudentBO("关羽", "荆州", "男"));
        studentBOList.add(new StudentBO("大乔", "铜雀台", "女"));
        studentBOList.add(new StudentBO("小乔", "铜雀台", "女"));

        //EasyExcel.write(new File("D:\\my-doc\\export.xlsx"),StudentBO.class).sheet("学生花名册").doWrite(studentBOList);


//        Class<?> clazz = Class.forName("com.xsw.neo.service.model.bo.StudentBO");
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            I18nFieldAnnotation annotation = declaredField.getAnnotation(I18nFieldAnnotation.class);
//            if(annotation != null){
//                String title = annotation.title();
//                if(title.equals(LanguageEnum.CHINESE.getValue())){
//                    String value = annotation.value();
//                    System.out.println(value);
//                }
//
//            }
//        }

    }


}
