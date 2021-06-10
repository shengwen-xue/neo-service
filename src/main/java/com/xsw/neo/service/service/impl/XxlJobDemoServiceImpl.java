package com.xsw.neo.service.service.impl;

import com.xsw.neo.service.service.XxlJobDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * xxlJob定时任务接口实现
 *
 * @author xueshengwen
 * @since 2021/6/9 14:09
 */
@Slf4j
@Service
public class XxlJobDemoServiceImpl implements XxlJobDemoService {

    @Override
    public void readString(String str) {
        System.out.println("==================定时任务读取字符:" + str);
    }
}
