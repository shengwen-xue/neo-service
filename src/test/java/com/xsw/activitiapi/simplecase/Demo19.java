package com.xsw.activitiapi.simplecase;

import com.alibaba.fastjson.JSONObject;
import com.xsw.activitiapi.model.convert.MsUpData;
import com.xsw.activitiapi.utils.AESHelper;
import com.xsw.activitiapi.utils.DateToLong;
import com.xsw.activitiapi.utils.HttpUtils;
import lombok.Data;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2021/3/5 14:37
 */
public class Demo19 {

    private static String deviceId = "";
    private static String apiKey = "";
    private static String secretKey = "";
    private static String signal = "";

    private static String startTime = "2020-11-01 12:29:59";
    private static String endTime = "2021-03-03 10:59:59";

    private static String ivS = "426e26e82c704e59";
    private static String tokenUrl = "ws/auth_v1/auth_token/query/getWanAccessToken";
    private static String dataUrl = "zeta_v1/wan_ms/query/" + deviceId + "/getAppDataByDate?access_token=";


    public static void main(String[] args) throws Exception {
        List<MsUpData> msUpDataList = new LinkedList<>();
        String tokenParam = "api_key=" + apiKey + "&signal=" + signal;

        String tokenJson = HttpUtils.sendGet(tokenUrl, tokenParam);
        String[] tokenJsonArray = tokenJson.split("\"");
        String token = tokenJsonArray[5];
        System.out.println("token:" + token);

        List<String> list = DateToLong.splitMonth(startTime, endTime);

        for (String dateStr : list) {
            String[] split = dateStr.split(",");

            Date start = DateToLong.convertStringToDate(split[0]);
            Date end = DateToLong.convertStringToDate(split[1]);

            System.out.println("startTime:" + DateToLong.convertDataToLong(start));
            System.out.println("endTime:" + DateToLong.convertDataToLong(end));

            String content = "{\"startTime\": " + DateToLong.convertDataToLong(start) + ",\"endTime\": " + DateToLong.convertDataToLong(end) + "}";

            try {
                content = AESHelper.Encrypt(content, secretKey.getBytes(StandardCharsets.UTF_8), ivS.getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Encrypt:" + content);

            try {
                System.out.println("Decrypt:" + AESHelper.Decrypt(content, secretKey.getBytes(StandardCharsets.UTF_8)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            String pathUrl = dataUrl + token;
            String result = HttpUtils.sendPost(pathUrl, content);

            System.out.println(result);

            Result result1 = JSONObject.parseObject(result, Result.class);

            List<MsUpData> msUpData = JSONObject.parseArray(result1.getData(), MsUpData.class);

            msUpDataList.addAll(msUpData);
            System.out.println(msUpDataList.size());
        }
    }
}

@Data
class Result implements Serializable {
    private String data;
    private String errmsg;
    private String status;
    private String ts;
}