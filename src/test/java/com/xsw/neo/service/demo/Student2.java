package com.xsw.neo.service.demo;

import com.github.crab2died.annotation.ExcelField;
import com.xsw.neo.service.common.annotation.I18nField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xueshengwen
 * @since 2021/5/21 10:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 implements Serializable {

    @ExcelField(title = "学号", order = 1)
    @I18nField(titles = {"zh-cn|学号"})
    private Integer id;

    @ExcelField(title = "姓名", order = 2)
    @I18nField(titles = {"zh-cn|姓名"})
    private String name;

    @ExcelField(title = "性别", order = 3)
    @I18nField(titles = {"zh-cn|性别"})
    private String sex;

    @ExcelField(title = "地址", order = 4)
    @I18nField(titles = {"zh-cn|地址"})
    private String addr;
}
