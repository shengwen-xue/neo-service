package com.xsw.neo.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xsw.neo.service.model.entity.Person;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @ApiOperation(value = "测试上传到OSS")
    @PostMapping("/upload")
    public void upload(MultipartFile multipartFile) throws Exception {


        RestTemplate client = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        File file = multipartFileToFile(multipartFile);

        String name = file.getName();
        InputStream inputStream = new FileInputStream(file);

        String url = "http://10.160.8.107:9100/energy/ama/uploadFile?name=" + name;

        List<InputStream> objects = Lists.newLinkedList();
        objects.add(inputStream);

        MultiValueMap<String, List<InputStream>> params = new LinkedMultiValueMap<>();
        params.put("multipartFile", Collections.singletonList(objects));

        HttpEntity<MultiValueMap<String, List<InputStream>>> requestEntity = new HttpEntity<>(params, httpHeaders);
        ResponseEntity<String> response = client.exchange(url, HttpMethod.POST, requestEntity, String.class);

        JSONObject jsonObject = JSONObject.parseObject(response.getBody());

        System.out.println(jsonObject);

    }

    @ApiOperation(value = "测试上传到OSS2")
    @PostMapping("/upload2")
    public void upload2(MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        RestTemplate client = new RestTemplate();

        String url = "http://10.160.8.107:9100/energy/ama/uploadFile";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        List<MultipartFile> list = new ArrayList<>();
        list.add(multipartFile);

        MultiValueMap<String, MultipartFile> params = new LinkedMultiValueMap<>();
        params.put("multipartFile", list);

        //String projectCode = httpServletRequest.getHeader("projectCode");
        //String token = httpServletRequest.getHeader("Token");
        //String sessionKey = httpServletRequest.getHeader("sessionKey");

        HttpEntity<MultiValueMap<String, MultipartFile>> requestEntity = new HttpEntity<>(params, httpHeaders);
        ResponseEntity<String> exchange = client.exchange(url, HttpMethod.POST, requestEntity, String.class);

        System.out.println(exchange.getBody());
    }

    private static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
