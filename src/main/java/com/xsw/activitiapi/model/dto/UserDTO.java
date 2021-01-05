package com.xsw.activitiapi.model.dto;

import lombok.Data;

/**
 * 用户dto
 *
 * @author xueshengwen
 * @since 2020/12/18 13:31
 */
@Data
public class UserDTO {
    private String userId;
    private String userName;
    private String roleId;
    private String roleName;
}
