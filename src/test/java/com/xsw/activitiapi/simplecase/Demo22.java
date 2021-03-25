package com.xsw.activitiapi.simplecase;

import com.xsw.activitiapi.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xueshengwen
 * @since 2021/3/24 15:09
 */
public class Demo22 {

    public static void main(String[] args) {
        String url = "http://localhost:9098/dataservice/alarm/collectAlarmData";
        Map<String, String> map = new HashMap<>();
        map.put("deviceId", "4f0094e3");
        map.put("endDate", "2021-03-25 17:30:00");
        map.put("startDate", "2021-03-25 00:00:00");
        String result = HttpUtils.sendPost(url, map);
        System.out.println(result);
    }
}
