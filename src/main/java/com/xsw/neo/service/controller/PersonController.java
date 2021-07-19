package com.xsw.neo.service.controller;

import com.xsw.neo.service.model.entity.Person;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xueshengwen
 * @since 2021/7/16 16:28
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/login")
    public String login(Person person, HttpServletRequest request) {
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(person.getUsername(), person.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try {
            // 开始认证，这一步会跳到我们自定义的realm中
            subject.login(token);
            request.getSession().setAttribute("person", person);

            return "";
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("person", person);
            request.setAttribute("error", "用户名或密码错误！");
            return "";
        }
    }
}
