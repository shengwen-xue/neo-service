package com.xsw.neo.service.controller;

import com.xsw.neo.service.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 工作流控制器
 *
 * @author xueshengwen
 * @since 2020/12/17 14:30
 */
@Api(tags = "工作流相关接口")
@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

    @Resource
    private ActivityService activityService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;
    @Resource
    private RepositoryService repositoryService;

    @ApiOperation(value = "创建流程")
    @PostMapping("/createDeployment")
    public boolean createDeployment() {
        return activityService.createDeployment();
    }

    @ApiOperation(value = "启动流程")
    @GetMapping("/startActivityDemo/{key}")
    public boolean startActivityDemo(@ApiParam(name = "流程编号", required = true)
                                     @PathVariable String key) {
        return activityService.startActivityDemo(key);
    }

    @ApiOperation(value = "代办列表")
    @GetMapping("/getTaskList")
    public boolean getTaskList() {
        return activityService.getTaskList();
    }

    @ApiOperation(value = "提交流程")
    @GetMapping("/complete/{taskId}")
    public boolean complete(@ApiParam(name = "任务ID", required = true)
                            @PathVariable String taskId) {
        return activityService.complete(taskId);
    }

    @ApiOperation(value = "删除流程")
    @DeleteMapping("/deleteProcessInstance/{runId}")
    public boolean deleteProcessInstance(@ApiParam(name = "运行ID", required = true)
                                         @PathVariable String runId) {
        return activityService.deleteProcessInstance(runId);
    }

    @ApiOperation(value = "第一个工作流demo")
    @GetMapping(value = "/firstDemo")
    public void firstDemo() {
        // 根据bpmn文件部署流程
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("demo2.bpmn").deploy();
        // 获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        // 启动流程定义，返回流程实例
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
