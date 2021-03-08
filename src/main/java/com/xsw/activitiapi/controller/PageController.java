package com.xsw.activitiapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xueshengwen
 * @since 2021/3/8 13:38
 */
@RequestMapping
@Controller
public class PageController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
