package com.xsw.neo.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/5/11 15:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.datasource1")
public class DataSource1Properties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
