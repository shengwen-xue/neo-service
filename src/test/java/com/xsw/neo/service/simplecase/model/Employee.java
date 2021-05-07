package com.xsw.neo.service.simplecase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工类
 *
 * @author xueshengwen
 * @since 2020/12/22 13:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;

    private String sex;

    private int age;

    private Double salary;

    private String area;
}
