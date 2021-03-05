package com.xsw.activitiapi.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Data
public class User implements Serializable {

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码
     */
    private String passwords;

    /**
     * 用户显示名称
     */
    private String displayName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * 状态
     */
    private String ustatus;

    /**
     * 地址
     */
    private String address;

    private String remarks;

    private Integer groupId;

    private String sex;

    private String position;

    private Integer systemLevel;

    private Integer leaderId;

    private Integer projectId;
}
