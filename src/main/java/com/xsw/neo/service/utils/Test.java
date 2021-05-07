package com.xsw.neo.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/4/2 15:54
 */
@Slf4j
@Component
public class Test {

    @Value(value = "${mqtt.url}")
    private String url;

    public String test() {
        System.out.println("url:" + url);
        return url;
    }
}
