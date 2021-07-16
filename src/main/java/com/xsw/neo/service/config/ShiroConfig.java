package com.xsw.neo.service.config;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Shiro配置
 *
 * @author xueshengwen
 * @since 2021/7/16 15:31
 */
@Slf4j
@Configuration
public class ShiroConfig {

    /**
     * 注入自定义的realm
     *
     * @return
     */
    @Bean
    public MyRealm authRealm() {
        MyRealm realm = new MyRealm();
        log.info("MyRealm注册完成");
        return realm;
    }

    /**
     * 注入安全管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        // 将自定义realm加进来
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(authRealm());
        log.info("SecurityManager注册完成");
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager) {
        // 定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置自定义的securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登录的url，身份认证失败会访问该url
        shiroFilterFactoryBean.setLoginUrl("login");
        // 设置成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 设置未授权界面，权限认证失败会访问该url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap是有序的，进行顺序拦截器配置
        Map<String, String> filterChainDefinitionMap = Maps.newLinkedHashMap();
        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon表示放行
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/doc.html", "anon");
        // 登录url 放行
        filterChainDefinitionMap.put("/login", "anon");
        // /** 表示所有都需要身份认证，authc表示要身份认证
        //filterChainDefinitionMap.put("/**", "authc");
        // 配置logout过滤器
        filterChainDefinitionMap.put("/logout", "logout");

        // 设置shiroFilterFactoryBean的FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
