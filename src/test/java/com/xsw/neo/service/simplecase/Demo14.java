package com.xsw.neo.service.simplecase;

import com.xsw.neo.service.utils.HMACSHAHelper;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xueshengwen
 * @since 2021/2/4 17:03
 */
public class Demo14 {

    private static final String apiKey = "";

    private static final String secretKey = "";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String signature = HMACSHAHelper.getSHA1Signature(apiKey.getBytes(), secretKey.getBytes());
        System.out.println(signature);
    }
}
