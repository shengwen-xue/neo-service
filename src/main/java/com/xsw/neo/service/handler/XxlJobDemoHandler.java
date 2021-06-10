package com.xsw.neo.service.handler;

import com.xsw.neo.service.service.XxlJobDemoService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshengwen
 * @since 2021/6/9 14:14
 */
@JobHandler(value = "demoHandler")
@Component
@Slf4j
@RequiredArgsConstructor
public class XxlJobDemoHandler extends IJobHandler {

    @Autowired
    private XxlJobDemoService xxlJobDemoService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("xxl-job测试任务开始执行。[args: {}]", s);
        try {
            xxlJobDemoService.readString(s);
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return FAIL;
        }
    }
}
