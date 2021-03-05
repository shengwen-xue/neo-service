package com.xsw.activitiapi.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Data
public class Role implements Serializable {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String description;

    private Integer groupId;
}
