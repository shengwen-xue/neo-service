package com.xsw.activitiapi.simplecase;

import java.math.BigInteger;

/**
 * @author xueshengwen
 * @since 2021/2/19 17:49
 */
public class Demo15 {

    private static String bytes2hex03(byte[] bytes) {
        final String HEX = "0123456789abcdef";
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(HEX.charAt((b >> 4) & 0x0f));
            sb.append(HEX.charAt(b & 0x0f));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "02010009";
//        String s = bytes2hex03(str.getBytes());
        long l = Long.parseLong(str, 16);
        System.out.println(l);

        System.out.println(str.substring(0, 2));
    }
}
