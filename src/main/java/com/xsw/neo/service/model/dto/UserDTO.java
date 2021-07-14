package com.xsw.neo.service.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户DTO
 *
 * @author xueshengwen
 * @since 2021/7/13 17:39
 */
@Data
@ApiModel
public class UserDTO implements Serializable {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String tel;
}
