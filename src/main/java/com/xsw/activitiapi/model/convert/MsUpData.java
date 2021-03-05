package com.xsw.activitiapi.model.convert;

import lombok.Data;

import java.io.Serializable;

/**
 * 终端上传
 *
 * @author xueshengwen
 * @since 2021/2/19 15:49
 */
@Data
public class MsUpData implements Serializable {

    /**
     * 设备 ID
     */
    private String uid;

    /**
     * 上报时间，秒级时间戳
     */
    private String upTime;

    /**
     * 解析后的数据，各字段含义参考【传感器应用层上行数据说明】文档
     */
    private String parsedAppData;

    /**
     * 原始数据
     */
    private String rawAppData;
}
