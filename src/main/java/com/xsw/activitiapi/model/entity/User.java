package com.xsw.activitiapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("passwords")
    private String passwords;

    /**
     * 用户显示名称
     */
    @TableField("display_name")
    private String displayName;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("mailbox")
    private String mailbox;

    /**
     * 状态
     */
    @TableField("ustatus")
    private String ustatus;

    /**
     * 是否锁定
     */
//    @TableField("locking")
//    private Integer locking;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    @TableField("remarks")
    private String remarks;

    @TableField("group_id")
    private Integer groupId;

    @TableField("sex")
    private String sex;

    @TableField("position")
    private String position;

    @TableField("systemLevel")
    private Integer systemLevel;

    @TableField("leaderId")
    private Integer leaderId;

    @TableField("projectId")
    private Integer projectId;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
