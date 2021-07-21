package com.xsw.neo.service.utils;

import com.xsw.neo.service.common.annotation.I18nAnnotation;

import java.lang.reflect.Field;

/**
 * @author xueshengwen
 * @since 2021/7/19 16:53
 */
public class MyAnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.xsw.neo.service.model.bo.PersonBO");
        StringBuilder stringBuilder1 = new StringBuilder("中文简体：");
        StringBuilder stringBuilder2 = new StringBuilder("英文：");
        StringBuilder stringBuilder3 = new StringBuilder("法语：");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            I18nAnnotation annotation = declaredField.getAnnotation(I18nAnnotation.class);
            if (annotation != null) {
                String[] array = annotation.langs();
                for (String str : array) {
                    String[] split = str.split("\\|");
                    String s = split[0];
                    switch (s) {
                        case "zh-cn":
                            stringBuilder1.append(split[1] + ",");
                            break;
                        case "en-us":
                            stringBuilder2.append(split[1] + ",");
                            break;
                        case "fr-fr":
                            stringBuilder3.append(split[1] + ",");
                            break;
                        default:
                            break;
                    }
                }

            }
        }

        System.out.println(stringBuilder1.toString().substring(0, stringBuilder1.length() - 1));
        System.out.println(stringBuilder2.toString().substring(0, stringBuilder2.length() - 1));
        System.out.println(stringBuilder3.toString().substring(0, stringBuilder3.length() - 1));
    }
}
