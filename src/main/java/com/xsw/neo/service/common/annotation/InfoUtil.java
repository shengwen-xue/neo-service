package com.xsw.neo.service.common.annotation;

import java.lang.reflect.Field;

/**
 * @author xueshengwen
 * @since 2021/5/21 11:09
 */
public class InfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(I18nField.class)) {
                I18nField name = field.getAnnotation(I18nField.class);
                String[] titles = name.titles();
                System.out.println(titles);
            }
        }
    }
}
