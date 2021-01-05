package com.xsw.activitiapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("t_userRole")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @TableField("user_id")
    private Integer userId;

    @TableField("role_id")
    private Integer roleId;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
