package com.xsw.neo.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/5/11 15:54
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.datasource2")
public class DataSource2Properties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
