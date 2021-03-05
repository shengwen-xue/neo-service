package com.xsw.activitiapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 学生类
 *
 * @author xueshengwen
 * @since 2021/3/4 11:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private String name;

    private Integer age;

    private String telNumber;

    private String addr;
}
