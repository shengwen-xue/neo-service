package com.xsw.activitiapi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author xueshengwen
 * @since 2021/3/8 13:38
 */
@Controller
public class PageController {

    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置response响应
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 38);
        System.out.println(lineCaptcha.getCode());
        //将验证码放到HttpSession里面
        request.getSession().setAttribute(SESSION_KEY_IMAGE_CODE, lineCaptcha.getCode());

        //图形验证码写出，可以写出到文件，也可以写出到流
        //输出浏览器
        OutputStream out = response.getOutputStream();
        lineCaptcha.write(out);
        out.flush();
        out.close();

    }
}
