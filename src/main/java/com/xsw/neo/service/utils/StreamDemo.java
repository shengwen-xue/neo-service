package com.xsw.neo.service.utils;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;
import com.xsw.neo.service.model.vo.StudentVO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xueshengwen
 * @since 2021/7/9 9:40
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> numList = Lists.newArrayList();
        numList.add(99);
        numList.add(2);
        numList.add(390);
        numList.add(28);

        List<Integer> sortedNumbers = numList.stream().sorted().collect(Collectors.toList());
        Console.log(sortedNumbers);

        List<String> list = Lists.newArrayList();
        list.add("bbb");
        list.add("aaa");
        list.add("ddd");
        list.add("ccc");

        List<String> collect = list.stream().sorted().collect(Collectors.toList());
        Console.log(collect);


        StudentVO studentVO1 = new StudentVO("薛胜文", "上海是浦东新区张江镇孙耀路申城佳苑二期");
        StudentVO studentVO2 = new StudentVO("薛胜文", "甘肃省武威市凉州区");
        StudentVO studentVO3 = new StudentVO("郭靖", "打狗棒法");
        StudentVO studentVO4 = new StudentVO("郭靖", "九阴神功");
        StudentVO studentVO5 = new StudentVO("郭靖", "降龙十八掌");

        List<StudentVO> studentList = Lists.newArrayList();
        studentList.add(studentVO1);
        studentList.add(studentVO2);
        studentList.add(studentVO3);
        studentList.add(studentVO4);
        studentList.add(studentVO5);

        // 分组聚合
        Map<String, List<String>> map = studentList.stream().collect(Collectors.groupingBy(
                StudentVO::getName, Collectors.mapping(StudentVO::getAddr, Collectors.toList())));
        Console.log(map);

        // 集合转map
        Map<String, StudentVO> nameAndStudentVO = studentList.stream().collect(
                Collectors.toMap(StudentVO::getName, studentVO -> studentVO, (k1, k2) -> k1));
        Console.log(nameAndStudentVO);

        Map<String, StudentVO> nameAndStudentVO2 = studentList.stream().collect(
                Collectors.toMap(StudentVO::getName, studentVO -> studentVO, (k1, k2) -> k2));
        Console.log(nameAndStudentVO2);

        // 集合转map
        // 拓展：要是存在相同的key, 按照创建时间倒序，就取k1，按照创建时间升序，就取k2
        Map<String, String> nameAndAddr = studentList.stream().collect(
                Collectors.toMap(StudentVO::getName, StudentVO::getAddr, (k1, k2) -> k2));
        Console.log(nameAndAddr);
    }
}
