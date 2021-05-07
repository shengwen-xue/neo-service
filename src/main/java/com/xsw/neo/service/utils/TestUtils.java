package com.xsw.neo.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xueshengwen
 * @since 2021/3/23 16:03
 */
@Slf4j
@Configuration
public class TestUtils {

    private static String host;

    @Value(value = "${host}")
    public void set(String host) {
        TestUtils.host = host;
    }

    public static String init() {
        log.info("初始化...");
        System.out.println("host：----------------->" + host);
        return "host：----------------->" + host;
    }
}
