package com.xsw.neo.service.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xueshengwen
 * @since 2021/8/30 18:11
 */
public class VerifyCodeUtil {
    private final static Map<Integer, String> TYPE = new HashMap<>(2);
    private final static int SUB = 0;
    private final static int PLUS = 1;

    static {
        TYPE.put(SUB, "-");
        TYPE.put(PLUS, "+");
    }

    public static String[] generate() {
        Random random = new Random();
        int type = random.nextInt(2);
        int[] arr = new int[]{random.nextInt(50), random.nextInt(50), Integer.MAX_VALUE};
        switch (type) {
            case SUB:  // 不出现负数
                if (arr[0] < arr[1]) {
                    arr[0] ^= arr[1];
                    arr[1] ^= arr[0];
                    arr[0] ^= arr[1];
                }
                arr[2] = arr[0] - arr[1];
                break;
            case PLUS:
                arr[2] = arr[0] + arr[1];
                break;
        }
        String[] ret = new String[]{arr[0] + "", arr[1] + "", arr[2] + ""};
        // 选一随机位置为"?"
        int pos = random.nextInt(3);
        String answer = ret[pos];
        ret[pos] = "?";
        return new String[]{ret[0] + TYPE.get(type) + ret[1] + "=" + ret[2], answer};
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String[] s = generate();
            System.out.println("verify code：" + s[0]);
            System.out.println("answer：" + s[1]);
        }

    }

}
