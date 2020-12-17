package com.xsw.activitiapi.service.impl;

import com.xsw.activitiapi.service.ActivityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xueshengwen
 * @since 2020/12/17 14:38
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;

    @Override
    public boolean createDeployment() {
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("processes/test.bpmn");
        builder.deploy();
        return true;
    }

    @Override
    public boolean startActivityDemo(String key) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
        String id = processInstance.getId();
        System.out.println("流程id =" + id);
        return true;
    }

    @Override
    public boolean getTaskList() {
        // 获取待办的一些信息，这里可以传入需要查询的用户，
        // 我这里查询的所有待办
        List<Task> tasks = taskService.createTaskQuery().list();
        for (Task t : tasks) {
            System.out.println(t.getCreateTime());
            System.out.println(t.getId());
            System.out.println(t.getName());
            System.out.println(t.getProcessInstanceId());
            System.out.println(t.getTaskDefinitionKey());
            System.out.println(t.getParentTaskId());
        }
        return true;
    }

    @Override
    public boolean complete(String taskId) {
        taskService.complete(taskId);
        return true;
    }

    @Override
    public boolean deleteProcessInstance(String runId) {
        runtimeService.deleteProcessInstance(runId, "结束");
        return true;
    }
}
