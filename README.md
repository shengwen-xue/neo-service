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
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─xsw
│  │  │          └─neo
│  │  │              └─service
│  │  │                  │  NeoServiceApplication.java
│  │  │                  │  
│  │  │                  ├─common
│  │  │                  │  ├─annotation
│  │  │                  │  │      I18nField.java
│  │  │                  │  │      InfoUtil.java
│  │  │                  │  │      
│  │  │                  │  ├─constant
│  │  │                  │  │      TestConstants.java
│  │  │                  │  │      
│  │  │                  │  ├─enums
│  │  │                  │  │      BusinessEnum.java
│  │  │                  │  │      LanguageEnum.java
│  │  │                  │  │      StrategyEnum.java
│  │  │                  │  │      
│  │  │                  │  ├─exception
│  │  │                  │  │      CommonException.java
│  │  │                  │  │      IException.java
│  │  │                  │  │      
│  │  │                  │  └─result
│  │  │                  │          ResultBody.java
│  │  │                  │          
│  │  │                  ├─config
│  │  │                  │      DataSource1Properties.java
│  │  │                  │      DataSource2Properties.java
│  │  │                  │      DataSourceConfig.java
│  │  │                  │      DruidConfig.java
│  │  │                  │      DruidDBConfig.java
│  │  │                  │      SwaggerConfig.java
│  │  │                  │      
│  │  │                  ├─controller
│  │  │                  │      PageController.java
│  │  │                  │      StrategyController.java
│  │  │                  │      StudentController.java
│  │  │                  │      UserController.java
│  │  │                  │      
│  │  │                  ├─mapper
│  │  │                  │  │  StudentMapper.java
│  │  │                  │  │  UserMapper.java
│  │  │                  │  │  
│  │  │                  │  └─xml
│  │  │                  │          StudentMapper.xml
│  │  │                  │          UserMapper.xml
│  │  │                  │          
│  │  │                  ├─model
│  │  │                  │  ├─bo
│  │  │                  │  │      TestBO.java
│  │  │                  │  │      
│  │  │                  │  ├─convert
│  │  │                  │  │      Context.java
│  │  │                  │  │      MsUpData.java
│  │  │                  │  │      
│  │  │                  │  ├─dto
│  │  │                  │  │      TestDTO.java
│  │  │                  │  │      
│  │  │                  │  ├─entity
│  │  │                  │  │      Student.java
│  │  │                  │  │      StudentExample.java
│  │  │                  │  │      User.java
│  │  │                  │  │      UserExample.java
│  │  │                  │  │      
│  │  │                  │  ├─param
│  │  │                  │  │      UserQueryParam.java
│  │  │                  │  │      
│  │  │                  │  └─vo
│  │  │                  │          StudentVO.java
│  │  │                  │          
│  │  │                  ├─service
│  │  │                  │  │  Strategy.java
│  │  │                  │  │  StudentService.java
│  │  │                  │  │  UserService.java
│  │  │                  │  │  
│  │  │                  │  └─impl
│  │  │                  │          FastStrategy.java
│  │  │                  │          NormalStrategy.java
│  │  │                  │          SlowStrategy.java
│  │  │                  │          SmoothStrategy.java
│  │  │                  │          StudentServiceImpl.java
│  │  │                  │          UserServiceImpl.java
│  │  │                  │          
│  │  │                  └─utils
│  │  │                          AESHelper.java
│  │  │                          CommonUtil.java
│  │  │                          DateToLong.java
│  │  │                          Generator.java
│  │  │                          HMACSHAHelper.java
│  │  │                          HttpUtils.java
│  │  │                          PhoneNumberUtils.java
│  │  │                          QRCodeGenerator.java
│  │  │                          Test.java
│  │  │                          TestUtils.java
│  │  │                          TestUtils2.java
│  │  │                          
│  │  └─resources
│  │          application-dev.yml
│  │          application-prod.yml
│  │          application-service.yml
│  │          application-test.yml
│  │          application-uat.yml
│  │          application.yml
│  │          generatorConfig.xml
│  │          log4j2.xml
│  │          
│  └─test
│      └─java
│          └─com
│              └─xsw
│                  └─neo
│                      └─service
│                          │  ActivitiApiApplicationTests.java
│                          │  
│                          ├─demo
│                          │      Calculator.java
│                          │      Demo1.java
│                          │      Demo2.java
│                          │      Demo3.java
│                          │      Demo4.java
│                          │      Demo5.java
│                          │      Demo6.java
│                          │      Man.java
│                          │      Person.java
│                          │      Student2.java
│                          │      Women.java
│                          │      
│                          ├─easyexcel
│                          │      DemoDAO.java
│                          │      DemoDataListener.java
│                          │      ExportData.java
│                          │      ImportData.java
│                          │      
│                          └─simplecase
│                              │  Demo1.java
│                              │  Demo10.java
│                              │  Demo11.java
│                              │  Demo12.java
│                              │  Demo13.java
│                              │  Demo14.java
│                              │  Demo15.java
│                              │  Demo16.java
│                              │  Demo17.java
│                              │  Demo18.java
│                              │  Demo19.java
│                              │  Demo2.java
│                              │  Demo20.java
│                              │  Demo21.java
│                              │  Demo22.java
│                              │  Demo23.java
│                              │  Demo24.java
│                              │  Demo25.java
│                              │  Demo26.java
│                              │  Demo27.java
│                              │  Demo28.java
│                              │  Demo29.java
│                              │  Demo3.java
│                              │  Demo30.java
│                              │  Demo4.java
│                              │  Demo5.java
│                              │  Demo6.java
│                              │  Demo7.java
│                              │  Demo8.java
│                              │  Demo9.java
│                              │  MyInterface.java
│                              │  PushCallback.java
│                              │  Test.java
│                              │  
│                              └─model
│                                      Employee.java
│                                      SexEnum.java
│                                      
└─target
    ├─classes
    │  │  application-dev.yml
    │  │  application-prod.yml
    │  │  application-service.yml
    │  │  application-test.yml
    │  │  application-uat.yml
    │  │  application.yml
    │  │  generatorConfig.xml
    │  │  log4j2.xml
    │  │  
    │  ├─com
    │  │  └─xsw
    │  │      └─neo
    │  │          └─service
    │  │              │  NeoServiceApplication.class
    │  │              │  
    │  │              ├─common
    │  │              │  ├─annotation
    │  │              │  │      I18nField.class
    │  │              │  │      InfoUtil.class
    │  │              │  │      
    │  │              │  ├─constant
    │  │              │  │      TestConstants.class
    │  │              │  │      
    │  │              │  ├─enums
    │  │              │  │      BusinessEnum.class
    │  │              │  │      LanguageEnum.class
    │  │              │  │      StrategyEnum.class
    │  │              │  │      
    │  │              │  ├─exception
    │  │              │  │      CommonException.class
    │  │              │  │      IException.class
    │  │              │  │      
    │  │              │  └─result
    │  │              │          ResultBody.class
    │  │              │          
    │  │              ├─config
    │  │              │      DataSource1Properties.class
    │  │              │      DataSource2Properties.class
    │  │              │      DataSourceConfig.class
    │  │              │      DruidConfig.class
    │  │              │      SwaggerConfig.class
    │  │              │      
    │  │              ├─controller
    │  │              │      PageController.class
    │  │              │      StrategyController.class
    │  │              │      StudentController.class
    │  │              │      UserController.class
    │  │              │      
    │  │              ├─mapper
    │  │              │  │  StudentMapper.class
    │  │              │  │  UserMapper.class
    │  │              │  │  
    │  │              │  └─xml
    │  │              │          StudentMapper.xml
    │  │              │          UserMapper.xml
    │  │              │          
    │  │              ├─model
    │  │              │  ├─bo
    │  │              │  │      TestBO.class
    │  │              │  │      
    │  │              │  ├─convert
    │  │              │  │      Context.class
    │  │              │  │      MsUpData.class
    │  │              │  │      
    │  │              │  ├─dto
    │  │              │  │      TestDTO.class
    │  │              │  │      
    │  │              │  ├─entity
    │  │              │  │      Student.class
    │  │              │  │      StudentExample$Criteria.class
    │  │              │  │      StudentExample$Criterion.class
    │  │              │  │      StudentExample$GeneratedCriteria.class
    │  │              │  │      StudentExample.class
    │  │              │  │      User.class
    │  │              │  │      UserExample$Criteria.class
    │  │              │  │      UserExample$Criterion.class
    │  │              │  │      UserExample$GeneratedCriteria.class
    │  │              │  │      UserExample.class
    │  │              │  │      
    │  │              │  ├─param
    │  │              │  │      UserQueryParam.class
    │  │              │  │      
    │  │              │  └─vo
    │  │              │          StudentVO.class
    │  │              │          
    │  │              ├─service
    │  │              │  │  Strategy.class
    │  │              │  │  StudentService.class
    │  │              │  │  UserService.class
    │  │              │  │  
    │  │              │  └─impl
    │  │              │          FastStrategy.class
    │  │              │          NormalStrategy.class
    │  │              │          SlowStrategy.class
    │  │              │          SmoothStrategy.class
    │  │              │          StudentServiceImpl.class
    │  │              │          UserServiceImpl.class
    │  │              │          
    │  │              └─utils
    │  │                      AESHelper.class
    │  │                      CommonUtil.class
    │  │                      DateToLong.class
    │  │                      Generator.class
    │  │                      HMACSHAHelper.class
    │  │                      HttpUtils.class
    │  │                      PhoneNumberUtils.class
    │  │                      QRCodeGenerator.class
    │  │                      Test.class
    │  │                      TestUtils.class
    │  │                      TestUtils2.class
    │  │                      
    │  └─META-INF
    │          neo-service.kotlin_module
    │          
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    ├─maven-status
    │  └─maven-compiler-plugin
    │      ├─compile
    │      │  └─default-compile
    │      │          createdFiles.lst
    │      │          inputFiles.lst
    │      │          
    │      └─testCompile
    │          └─default-testCompile
    │                  createdFiles.lst
    │                  inputFiles.lst
    │                  
    └─test-classes
        ├─com
        │  └─xsw
        │      └─neo
        │          └─service
        │              │  ActivitiApiApplicationTests.class
        │              │  
        │              ├─demo
        │              │      Calculator.class
        │              │      Demo1.class
        │              │      Demo2.class
        │              │      Demo3.class
        │              │      Demo4.class
        │              │      Demo5.class
        │              │      Demo6.class
        │              │      Man.class
        │              │      Person.class
        │              │      Student2.class
        │              │      Women.class
        │              │      
        │              ├─easyexcel
        │              │      DemoDAO.class
        │              │      DemoDataListener.class
        │              │      ExportData.class
        │              │      ImportData.class
        │              │      
        │              └─simplecase
        │                  │  Demo1.class
        │                  │  Demo10.class
        │                  │  Demo11.class
        │                  │  Demo12.class
        │                  │  Demo13.class
        │                  │  Demo14.class
        │                  │  Demo15.class
        │                  │  Demo16.class
        │                  │  Demo17.class
        │                  │  Demo18$1.class
        │                  │  Demo18.class
        │                  │  Demo19.class
        │                  │  Demo2.class
        │                  │  Demo20.class
        │                  │  Demo21.class
        │                  │  Demo22.class
        │                  │  Demo23.class
        │                  │  Demo24.class
        │                  │  Demo25.class
        │                  │  Demo26.class
        │                  │  Demo27.class
        │                  │  Demo28.class
        │                  │  Demo29.class
        │                  │  Demo3.class
        │                  │  Demo30.class
        │                  │  Demo4.class
        │                  │  Demo5.class
        │                  │  Demo6.class
        │                  │  Demo7.class
        │                  │  Demo8$1.class
        │                  │  Demo8.class
        │                  │  Demo9.class
        │                  │  MyInterface.class
        │                  │  MyThread.class
        │                  │  PushCallback.class
        │                  │  Result.class
        │                  │  Test$1.class
        │                  │  Test$2.class
        │                  │  Test$3.class
        │                  │  Test.class
        │                  │  
        │                  └─model
        │                          Employee.class
        │                          SexEnum.class
```

# 功能特性(Features)
