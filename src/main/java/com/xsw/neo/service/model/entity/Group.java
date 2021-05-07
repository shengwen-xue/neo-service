package com.xsw.neo.service.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 分组
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Data
public class Group implements Serializable {

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 管理者id
     */
    private Integer manageUserId;
}
