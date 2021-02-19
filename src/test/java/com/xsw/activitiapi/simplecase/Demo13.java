package com.xsw.activitiapi.simplecase;

import com.xsw.activitiapi.utils.AESHelper;
import com.xsw.activitiapi.utils.DateToLong;
import com.xsw.activitiapi.utils.HttpUtils;

import java.util.Date;

/**
 * @author xueshengwen
 * @since 2021/2/4 9:45
 */
public class Demo13 {

    private static String deviceId = "";
    private static String apiKey = "";
    private static String secretKey = "";
    private static String signal = "";

    private static String startTime = "2021-02-01 00:00:00";
    private static String endTime = "2021-02-17 00:00:00";

    private static String ivS = "426e26e82c704e59";
    private static String tokenUrl = "http:///auth_v1/auth_token/query/getWanAccessToken";
    private static String dataUrl = "http:///zeta_v1/wan_ms/query/" + deviceId + "/getMsUploadDataByDate?access_token=";


    public static void main(String[] args) {
        String token = "";
        String tokenParam = "api_key=" + apiKey + "&signal=" + signal;

        String tokenJson = HttpUtils.sendGet(tokenUrl, tokenParam);
        String[] tokenJsonArray = tokenJson.split("\"");
        token = tokenJsonArray[5];
        System.out.println("token:" + token);

        Date start = DateToLong.convertStringToDate(startTime);
        Date end = DateToLong.convertStringToDate(endTime);

        System.out.println("startTime:" + DateToLong.convertDataToLong(start));
        System.out.println("endTime:" + DateToLong.convertDataToLong(end));

        String content = "{\"starttime\": " + DateToLong.convertDataToLong(start) + ",\"endtime\": " + DateToLong.convertDataToLong(end) + "}";

        try {
            content = AESHelper.Encrypt(content, secretKey.getBytes("utf8"), ivS.getBytes("utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Encrypt:" + content);

        try {
            System.out.println("Decrypt:" + AESHelper.Decrypt(content, secretKey.getBytes("utf8")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String pathUrl = dataUrl + token;
        String result = HttpUtils.sendPost(pathUrl, content);

        System.out.println(result);
    }
}

