package com.xsw.neo.service.controller;

import com.google.code.kaptcha.Producer;
import com.xsw.neo.service.utils.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xueshengwen
 * @since 2021/8/31 10:24
 */
@RestController
public class TestCode {

    private static final String CAPTCHA_KEY = "auth:captcha:";

    private static Map<String, String> codeMap = new HashMap<>(1);

    @Resource
    private Producer producer;

    @GetMapping(path = "/testCode")
    public void testCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        String key = UUID.randomUUID().toString().replace("-", "");
        System.out.println("UUID:[" + key + "]");

        //生成文字验证码
        //String text = producer.createText();

        //个位数字相加
        //String s1 = text.substring(0, 1);
        //String s2 = text.substring(1, 2);
        //int count = Integer.valueOf(s1).intValue() + Integer.valueOf(s2).intValue();
        //System.out.println("count:[" + count + "]");
        //生成图片验证码
        //BufferedImage image = producer.createImage(s1 + "+" + s2 + "=?");
        String[] generate = VerifyCodeUtil.generate();
        BufferedImage image = producer.createImage(generate[0]);
        System.out.println("answer:[" + generate[1] + "]");
        //保存 redis key 自己设置
        //stringRedisTemplate.opsForValue().set(CAPTCHA_KEY+key,generate[1]);

        // 模拟验证码存入redis
        codeMap.put(key, generate[1]);

        HttpSession session = request.getSession();
        session.setAttribute("captcha", key);
        //session.setMaxInactiveInterval(10);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.close();
    }

    @GetMapping(path = "/vCode")
    public void vCode(HttpServletRequest request, String code) {
        String key = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isBlank(key)) {
            System.out.println("session 的验证码UUID失效！");
        }
        String localCode = codeMap.get(key);
        if (StringUtils.isBlank(localCode)) {
            System.out.println("验证码已过期！");
            return;
        }
        if (!StringUtils.equalsIgnoreCase(code, localCode)) {
            System.out.println("验证码错误");
            return;
        }
        System.out.println("验证通过！");
        codeMap.clear();
    }
}
