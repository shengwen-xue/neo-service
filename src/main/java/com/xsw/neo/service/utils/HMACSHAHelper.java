package com.xsw.neo.service.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xueshengwen
 * @since 2021/2/4 16:59
 */
public class HMACSHAHelper {

    private static final String HMAC_SHA1 = "HmacSHA1";

    /**
     * 生成签名数据
     *
     * @param data 待加密的数据 这里为 api_key
     * @param key  加密使用的 key 这里为 secret_key
     * @return 生成十六进制字符串
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    public static String getSHA1Signature(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException {
        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data);
        return CommonUtil.bytesToHexString(rawHmac);
    }
}
