package com.xsw.activitiapi.service;

/**
 * @author xueshengwen
 * @since 2020/12/17 14:31
 */
public interface ActivityService {
    /**
     * 注册流程
     *
     * @return
     */
    boolean createDeployment();

    /**
     * 启动流程
     *
     * @param test bpmn名称
     * @return
     */
    boolean startActivityDemo(String test);

    /**
     * 获取待办
     *
     * @return 代办列表
     */
    boolean getTaskList();

    /**
     * 提交
     *
     * @param taskId 任务编号
     * @return
     */
    boolean complete(String taskId);

    /**
     * 根据流程id直接结束流程
     *
     * @param runId 运行编号
     * @return
     */
    boolean deleteProcessInstance(String runId);
}
