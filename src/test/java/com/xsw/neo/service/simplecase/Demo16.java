package com.xsw.neo.service.simplecase;

import com.xsw.neo.service.common.constant.TestConstants;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xueshengwen
 * @since 2021/2/24 11:26
 */
public class Demo16 {

    private static boolean isNotEmptyBatch(String... params) {
        for (String param : params) {
            if (StringUtils.isBlank(param)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String str = "electric current";
        System.out.println(str.toUpperCase());

        System.out.println(TestConstants.COMMON_URL);
        System.out.println(TestConstants.ILLUMINANCE);

        boolean notEmptyBatch = isNotEmptyBatch("123456", "000", "2021");
        System.out.println(notEmptyBatch);
    }
}
