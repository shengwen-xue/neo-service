package com.xsw.activitiapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueshengwen
 * @since 2020/12/17 13:50
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "111";
    }
}