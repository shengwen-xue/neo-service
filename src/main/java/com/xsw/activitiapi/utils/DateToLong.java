package com.xsw.activitiapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToLong {

    public static void main(String[] args) {
        Date date = convertStringToDate("2018-03-05 19:00:00");
        Long time = convertDataToLong(date);
        System.out.println(time);
    }

    public static Long convertDataToLong(Date date) {
        // 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的
        // <a href="https://www.baidu.com/s?wd=%E6%AF%AB%E7%A7%92&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1d9PHnYnW99uH-huHc4uHf30ZwV5Hcvrjm3rH6sPfKWUMw85HfYnjn4nH6sgvPsT6KdThsqpZwYTjCEQLGCpyw9Uz4Bmy-bIi4WUvYETgN-TLwGUv3EPjf3PjbLPjDv" target="_blank" class="baidu-highlight">毫秒</a>数。
        return date.getTime() / 1000;
    }

    public static Date convertStringToDate(String dateString) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }
}