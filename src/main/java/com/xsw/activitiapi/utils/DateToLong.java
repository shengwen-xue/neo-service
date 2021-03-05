package com.xsw.activitiapi.utils;

import cn.hutool.core.lang.Console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateToLong {

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

    public static void getIntervalTimeByMonth(Long startTime, Long endTime, List<Long> beginDateList, List<Long> endDateList) {
        Date startDate = new Date(startTime);
        Date endDate = new Date(endTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        beginDateList.add(calendar.getTimeInMillis());
        while (calendar.getTimeInMillis() < endDate.getTime()) {
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            if (calendar.getTimeInMillis() < endDate.getTime()) {
                endDateList.add(calendar.getTimeInMillis());
            } else {
                endDateList.add(endDate.getTime());
                break;
            }
            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            beginDateList.add(calendar.getTimeInMillis());
        }
    }

    public static List<String> splitMonth(String start, String end) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startDate = simpleDateFormat.parse(start);
        Date endDate = simpleDateFormat.parse(end);

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        // 开始时间段区间集合
        List<Long> beginDateList = new ArrayList<>();
        // 结束时间段区间集合
        List<Long> endDateList = new ArrayList<>();

        List<String> list = new LinkedList<>();

        getIntervalTimeByMonth(startTime, endTime, beginDateList, endDateList);
        for (int i = 0; i < beginDateList.size(); i++) {
            String beginStr = simpleDateFormat.format(new Date(beginDateList.get(i)));
            String endStr = simpleDateFormat.format(new Date(endDateList.get(i)));
            list.add(beginStr + "," + endStr);
            System.out.println("第" + i + "段时间区间:" + beginStr + "-------" + endStr);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        Date date = convertStringToDate("2018-03-05 19:00:00");
        Long time = convertDataToLong(date);
        System.out.println(time);

        // startDate = startDate 向后取一个月
        // startDate 向后取一个月
        // ....
        // startDate 和 endDate 是一个月就停止向后取

        String startDate = "2020-11-01 12:29:59";
        String endDate = "2021-03-03 10:59:59";

        List<String> list = splitMonth(startDate, endDate);

        Console.log(list);
    }
}