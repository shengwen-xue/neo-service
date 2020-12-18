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
@TableName("t_group")
public class Group extends Model<Group> {

    private static final long serialVersionUID = 1L;

    /**
     * 组名称
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 创建人id
     */
    @TableField("create_user_id")
    private Integer createUserId;

    /**
     * 管理者id
     */
    @TableField("manage_user_id")
    private Integer manageUserId;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
