package com.xsw.activitiapi.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
@Data
@TableName("t_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 备注
     */
    @TableField("description")
    private String description;

    @TableField("group_id")
    private Integer groupId;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
