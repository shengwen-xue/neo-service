package com.xsw.neo.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueshengwen
 * @since 2021/8/17 11:13
 */
@RestController
@RequestMapping("/foo")
public class KeycloakController {

    @GetMapping("/bar")
    public String bar() {
        return "MyClient";
    }
}
