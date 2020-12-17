package com.xsw.activitiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.activiti.spring.boot.SecurityAutoConfiguration.class
})
public class ActivitiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApiApplication.class, args);
    }
}
