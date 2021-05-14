# 介绍(introduction)
### 简单的demo

# 技术栈(Technologies)
<ul>
    <li>spring boot 2.x</li>
    <li>hutool 5.4.2</li>
    <li>easyexcel 2.2.6</li>
    <li>mybatis-plus 3.0.3</li>
    <li>activiti 5.22.0</li>
    <li>javase 3.3.0</li>
    <li>lombok</li>
    <li>maven</li>
    <li>swagger2 2.8.0</li>
    <li>swagger-ui 2.8.0</li>
    <li>bootstrap-ui 1.9.6</li>
    <li>commons-pool2 2.4.2</li>
    <li>fastjson 1.2.62</li>
    <li>gson 2.8.5</li>
    <li><s>mqttv3 1.2.0</s></li>
    <li>freemarker</li>
    <li>jacoco 0.8.3</li>
</ul>


# 启动(Launch or Setup)
```java 
IDEA编辑器配置Maven、jdk环境、Lombok插件 
git clone https://github.com/shengwen-xue/neo-service.git
修改数据源找到src下的NeoServiceApplication.java右键run启动 
启动成功后在浏览器输入http://localhost:9999/neo-service/swagger-ui.html 或者http://localhost:9999/neo-service/doc.html 操作文档 
```


# 目录(Table of contents)
```java  
├─main
│  ├─java
│  │  └─com
│  │      └─xsw
│  │          └─activitiapi
│  │              │  ActivityApiApplication.java
│  │              │  
│  │              ├─common
│  │              │  ├─constant
│  │              │  │      TestConstants.java
│  │              │  │      
│  │              │  ├─enums
│  │              │  │      BusinessEnum.java
│  │              │  │      IException.java
│  │              │  │      
│  │              │  ├─exception
│  │              │  │      CommonException.java
│  │              │  │      
│  │              │  └─result
│  │              │          ResultBody.java
│  │              │          
│  │              ├─config
│  │              │      DruidConfig.java
│  │              │      DruidDBConfig.java
│  │              │      SwaggerConfig.java
│  │              │      
│  │              ├─controller
│  │              │      ActivityController.java
│  │              │      PageController.java
│  │              │      PersonController.java
│  │              │      StudentController.java
│  │              │      UserController.java
│  │              │      
│  │              ├─mapper
│  │              │      TestMapper.java
│  │              │      
│  │              ├─model
│  │              │  ├─bo
│  │              │  │      TestBO.java
│  │              │  │      
│  │              │  ├─convert
│  │              │  │      MsUpData.java
│  │              │  │      
│  │              │  ├─dto
│  │              │  │      UserDTO.java
│  │              │  │      
│  │              │  ├─entity
│  │              │  │      Group.java
│  │              │  │      Person.java
│  │              │  │      PersonExample.java
│  │              │  │      Role.java
│  │              │  │      Student.java
│  │              │  │      User.java
│  │              │  │      UserRole.java
│  │              │  │      
│  │              │  └─vo
│  │              │          StudentVO.java
│  │              │          
│  │              ├─service
│  │              │  │  ActivityService.java
│  │              │  │  GroupService.java
│  │              │  │  PersonService.java
│  │              │  │  RoleService.java
│  │              │  │  StudentService.java
│  │              │  │  UserRoleService.java
│  │              │  │  UserService.java
│  │              │  │  
│  │              │  └─impl
│  │              │          ActivityServiceImpl.java
│  │              │          GroupServiceImpl.java
│  │              │          PersonServiceImpl.java
│  │              │          RoleServiceImpl.java
│  │              │          StudentServiceImpl.java
│  │              │          UserRoleServiceImpl.java
│  │              │          UserServiceImpl.java
│  │              │          
│  │              └─utils
│  │                      AESHelper.java
│  │                      CommonUtil.java
│  │                      DateToLong.java
│  │                      Generator.java
│  │                      HMACSHAHelper.java
│  │                      HttpUtils.java
│  │                      JDBCUtils.java
│  │                      QRCodeGenerator.java
│  │                      Test.java
│  │                      TestUtils.java
│  │                      TestUtils2.java
│  │                      
│  └─resources
│      │  application-service.yml
│      │  application.yml
│      │  generatorConfig.xml
│      │  
│      ├─mapper
│      └─processes
│              demo.bpmn
│              dispatchApplyProcess.bpmn
│              dispatchApplyProcess.xml
│              officeApply.bpmn
│              officeApply.xml
│              test.bpmn
│              test.xml
│              test1.bpmn
│              
└─test
    └─java
        └─com
            └─xsw
                └─activitiapi
                    │  ActivitiApiApplicationTests.java
                    │  
                    ├─demo
                    │      Calculator.java
                    │      Demo1.java
                    │      
                    ├─easyexcel
                    │      DemoDAO.java
                    │      DemoDataListener.java
                    │      ExportData.java
                    │      ImportData.java
                    │      
                    └─simplecase
                        │  Demo1.java
                        │  Demo10.java
                        │  Demo11.java
                        │  Demo12.java
                        │  Demo13.java
                        │  Demo14.java
                        │  Demo15.java
                        │  Demo16.java
                        │  Demo17.java
                        │  Demo18.java
                        │  Demo19.java
                        │  Demo2.java
                        │  Demo20.java
                        │  Demo21.java
                        │  Demo22.java
                        │  Demo23.java
                        │  Demo24.java
                        │  Demo25.java
                        │  Demo26.java
                        │  Demo27.java
                        │  Demo28.java
                        │  Demo29.java
                        │  Demo3.java
                        │  Demo30.java
                        │  Demo4.java
                        │  Demo5.java
                        │  Demo6.java
                        │  Demo7.java
                        │  Demo8.java
                        │  Demo9.java
                        │  MyInterface.java
                        │  PushCallback.java
                        │  Test.java
                        │  
                        └─model
                                Employee.java
                                SexEnum.java
```

# 功能特性(Features)
