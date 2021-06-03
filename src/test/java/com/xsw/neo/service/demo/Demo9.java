package com.xsw.neo.service.demo;

import com.google.common.collect.Maps;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/6/3 14:58
 */
public class Demo9 {

    public static void main(String[] args) {

        String url = "https://www.baidu.com/?tn={tn}";

        Map<String, Object> params = Maps.newLinkedHashMap();
        params.put("tn","baiduhome_pg");

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject(url, String.class, params);

        System.out.println(forObject);
    }
}
