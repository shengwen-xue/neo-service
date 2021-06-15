package com.xsw.neo.service.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/6/9 14:14
 */
@Component
public class XxlJobDemoHandler {

    @XxlJob(value = "demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) {
        System.out.println(param);


        return ReturnT.SUCCESS;
    }
}
