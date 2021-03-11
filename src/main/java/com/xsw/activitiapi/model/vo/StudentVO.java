package com.xsw.activitiapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xueshengwen
 * @since 2021/3/4 11:29
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO implements Serializable {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "地址")
    private String addr;
}
