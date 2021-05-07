package com.xsw.neo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class NeoServiceApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("spring.devtools.restart.enabled", "false");
            SpringApplication.run(NeoServiceApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
