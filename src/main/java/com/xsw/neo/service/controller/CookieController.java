package com.xsw.neo.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xueshengwen
 * @since 2021/6/15 18:42
 */
@Controller
@RequestMapping(value = "/cookie")
public class CookieController {

    @RequestMapping(value = "/cookieTest")
    public void cookieTest(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");

        Cookie cookie = new Cookie("userName", "xue");
        cookie.setMaxAge(100);

        response.addCookie(cookie);
        response.getWriter().write("我已经向浏览器发送了一个Cookie");
    }
}
