package com.xsw.activitiapi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xueshengwen
 * @since 2021/3/23 16:03
 */
@Slf4j
@Component
public class TestUtils2 {

    @Value(value = "${host}")
    private String host;

    private static String tmp;

    @PostConstruct
    public void set() {
        TestUtils2.tmp = host;
    }

    public static String init() {
        log.info("初始化...");
        System.out.println("host：----------------->" + tmp);
        return "host：----------------->" + tmp;
    }
}
