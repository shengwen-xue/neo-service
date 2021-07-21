package com.xsw.neo.service.model.bo;

import com.xsw.neo.service.common.annotation.I18nFieldAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 学生BO 测试自定义的多语言切换
 *
 * @author xueshengwen
 * @since 2021/3/4 11:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBO implements Serializable {

    @I18nFieldAnnotation(value = "姓名")
    private String name;

    @I18nFieldAnnotation(title = "en-us", value = "address1")
    private String address;

    @I18nFieldAnnotation(value = "性别")
    private String sex;
}
