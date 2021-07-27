package com.xsw.neo.service.config;

import com.xsw.neo.service.model.entity.Permission;
import com.xsw.neo.service.model.entity.Person;
import com.xsw.neo.service.model.entity.Role;
import com.xsw.neo.service.service.PermissionService;
import com.xsw.neo.service.service.PersonService;
import com.xsw.neo.service.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义realm
 *
 * @author xueshengwen
 * @since 2021/7/16 13:45
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private PersonService personService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 鉴权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 角色信息
        List<Role> roles = roleService.findRolesByName(username);
        Set<String> roleNameSet = roles.stream().map(Role::getRoleName).collect(Collectors.toSet());

        simpleAuthorizationInfo.setRoles(roleNameSet);

        // 权限信息
        List<Permission> permissions = permissionService.findPermissionsByName(username);
        Set<String> permissionNameSet = permissions.stream().map(Permission::getPermissionName).collect(Collectors.toSet());

        simpleAuthorizationInfo.setStringPermissions(permissionNameSet);

        return simpleAuthorizationInfo;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 根据token获取用户名
        // String username = (String) authenticationToken.getPrincipal();
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        Person person = personService.findPersonByName(usernamePasswordToken.getUsername());


        if (Objects.nonNull(person)) {

            // 把当前用户存到session中
            SecurityUtils.getSubject().getSession().setAttribute("person", person);

            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(person.getUsername(), person.getPassword(), "");
            return authenticationInfo;
        }
        return null;
    }
}
