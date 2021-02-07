package com.xsw.activitiapi.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AESHelper {
    public static void main(String[] args) throws Exception {
        SecureRandom sr = new SecureRandom();
        SecureRandom.getInstance("SHA1PRNG");
        byte[] ss = sr.generateSeed(16);
        String key = "";
        System.out.println("key: " + key);
        String content = "{\"starttime\":1568044800,\"endtime\":1568128983}";
//        String content = "{\"data\":\"889954\"}";
        System.out.println("content: " + content);
        String ivS = "426e26e82c704e59";
        System.out.println("ivS: " + ivS);
        // Encrypt
        String enString = AESHelper.Encrypt(content, key.getBytes("utf8"), ivS.getBytes("utf8"));
        System.out.println("After:" + enString);
        // Decrypt
        String DeString = AESHelper.Decrypt(enString, key.getBytes("utf8"));
        System.out.println("Before:" + DeString);
    }

    /**
     * aes cfb 模式加密
     *
     * @param content 需要加密内容 * @param key 密钥
     * @param ivS     偏移量c
     * @return
     * @throws Exception
     */
    public static String Encrypt(String content, byte[] key, byte[] ivS) throws Exception {
        byte[] raw = key;
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        IvParameterSpec iv = new IvParameterSpec(ivS);
        System.out.println("iv:" + iv.getIV());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes("utf8"));
        byte[] newB = new byte[ivS.length + encrypted.length];
        System.arraycopy(ivS, 0, newB, 0, ivS.length);
        System.arraycopy(encrypted, 0, newB, ivS.length, encrypted.length);
        return Base64.encode(newB);
    }

    /**
     * aes cfb 模式解密
     *
     * @param content 需要解密内容 * @param key 密钥
     * @return
     * @throws Exception
     */
    public static String Decrypt(String content, byte[] key) {
        try {
            byte[] raw = key;
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            byte[] encrypted = Base64.decode(content);
            byte[] ivS = new byte[16];
            System.arraycopy(encrypted, 0, ivS, 0, 16);
            byte[] encrypted1 = new byte[encrypted.length - 16];
            System.arraycopy(encrypted, 16, encrypted1, 0, encrypted.length - 16);
            IvParameterSpec iv = new IvParameterSpec(ivS);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}