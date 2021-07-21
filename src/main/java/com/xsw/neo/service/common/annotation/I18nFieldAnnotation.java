package com.xsw.neo.service.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xueshengwen
 * @since 2021/5/21 11:01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface I18nFieldAnnotation {

    /**
     * 国际化标题栏
     *
     * @return 国际化标题配置
     */
    String title() default "zh-cn";

    /**
     * 国际化值
     *
     * @return 国际化值
     */
    String value();
}
