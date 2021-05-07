package com.xsw.neo.service.simplecase;

import com.xsw.neo.service.utils.AESHelper;
import com.xsw.neo.service.utils.DateToLong;
import com.xsw.neo.service.utils.HttpUtils;

import java.nio.charset.StandardCharsets;
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

    private static String startTime = "2021-03-01 00:00:00";
    private static String endTime = "2021-03-03 10:59:59";

    private static String ivS = "426e26e82c704e59";
    private static String tokenUrl = "auth_v1/auth_token/query/getWanAccessToken";
    private static String dataUrl = "zeta_v1/wan_ms/query/" + deviceId + "/getAppDataByDate?access_token=";


    public static void main(String[] args) {
        String tokenParam = "api_key=" + apiKey + "&signal=" + signal;

        String tokenJson = HttpUtils.sendGet(tokenUrl, tokenParam);
        String[] tokenJsonArray = tokenJson.split("\"");
        String token = tokenJsonArray[5];
        System.out.println("token:" + token);

        Date start = DateToLong.convertStringToDate(startTime);
        Date end = DateToLong.convertStringToDate(endTime);

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
    }
}

