package com.xsw.neo.service.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生DTO
 *
 * @author xueshengwen
 * @since 2021/5/12 16:59
 */
@Data
@ApiModel
public class StudentDTO implements Serializable {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "性别：1：男，2：女")
    private Integer sex;
}
