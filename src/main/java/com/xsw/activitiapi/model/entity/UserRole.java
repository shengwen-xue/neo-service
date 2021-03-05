package com.xsw.activitiapi.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Data
public class UserRole implements Serializable {

    private Integer userId;

    private Integer roleId;
}
