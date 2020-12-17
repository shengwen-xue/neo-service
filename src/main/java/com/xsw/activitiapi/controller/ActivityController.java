package com.xsw.activitiapi.controller;

import com.xsw.activitiapi.service.ActivityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xueshengwen
 * @since 2020/12/17 14:30
 */
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;

    @PostMapping("/createDeployment")
    public boolean createDeployment() {
        return activityService.createDeployment();
    }

    @GetMapping("/startActivityDemo/{key}")
    public boolean startActivityDemo(@PathVariable String key) {
        return activityService.startActivityDemo(key);
    }

    @GetMapping("/getTaskList")
    public boolean getTaskList() {
        return activityService.getTaskList();
    }

    @GetMapping("/complete/{taskId}")
    public boolean complete(@PathVariable String taskId) {
        return activityService.complete(taskId);
    }

    @DeleteMapping("/deleteProcessInstance/{runId}")
    public boolean deleteProcessInstance(@PathVariable String runId) {
        return activityService.deleteProcessInstance(runId);
    }

    @RequestMapping("/firstDemo")
    public void firstDemo() {
        //根据bpmn文件部署流程
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("demo2.bpmn").deploy();
        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义，返回流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
        String processId = processInstance.getId();
        System.out.println("流程创建成功，当前流程实例ID：" + processId);

        Task task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第一次执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("第二次执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(processId).singleResult();
        System.out.println("任务执行完毕：" + task);
    }
}
