package com.xsw.neo.service.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xueshengwen
 * @since 2021/5/25 15:29
 */
@Data
public class Person implements Serializable {

    private String name;

    private Integer age;

    private Character sex;
}
