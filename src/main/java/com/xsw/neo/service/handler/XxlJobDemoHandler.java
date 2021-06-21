package com.xsw.neo.service.handler;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/6/9 14:14
 */
@Component
public class XxlJobDemoHandler {

    @XxlJob(value = "demo")
    public void demoJobHandler() {
        for (int i = 0; i < 5; i++) {
            System.out.println("当前：" + i);
        }
    }
}
