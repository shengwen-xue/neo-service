package com.xsw.activitiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
@EnableSwagger2
public class ActivityApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApiApplication.class, args);
    }
}
