package com.xsw.neo.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/7/13 11:41
 */
@Data
@Component
@ConfigurationProperties(prefix = "service")
public class ApplicationConfig {

    private String logUrl;

    private String loginUrl;

    private String logOutUrl;
}
