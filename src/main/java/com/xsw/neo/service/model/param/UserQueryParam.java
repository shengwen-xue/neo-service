package com.xsw.neo.service.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户查询参数
 *
 * @author xueshengwen
 * @since 2021/5/14 11:19
 */
@Data
@ApiModel
public class UserQueryParam implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电话")
    private String tel;
}
