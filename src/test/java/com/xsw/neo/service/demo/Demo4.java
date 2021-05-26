package com.xsw.neo.service.demo;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4jException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/5/19 18:08
 */
public class Demo4 {

    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();

        Student2 student1 = new Student2(1, "张三", "男", "上海");
        Student2 student2 = new Student2(2, "李四", "男", "上海");
        Student2 student3 = new Student2(2, "王五", "男", "上海");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        try {
            ExcelUtils.getInstance().exportObjects2Excel(list, Student2.class, true, "student", true, "D:\\1111\\student2-en.xlsx", "zh-cn");
        } catch (Excel4jException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
