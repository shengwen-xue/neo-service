package com.xsw.activitiapi.service;

/**
 * <p>
 * 工作流服务
 * </p>
 *
 * @author xueshengwen
 * @since 2020/12/17 14:31
 */
public interface ActivityService {

    /**
     * 注册流程
     *
     * @return 标识
     */
    boolean createDeployment();

    /**
     * 启动流程
     *
     * @param name bpmn名称
     * @return 标识
     */
    boolean startActivityDemo(String name);

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
     * @return 标识
     */
    boolean complete(String taskId);

    /**
     * 根据流程id直接结束流程
     *
     * @param runId 运行编号
     * @return 标识
     */
    boolean deleteProcessInstance(String runId);
}
