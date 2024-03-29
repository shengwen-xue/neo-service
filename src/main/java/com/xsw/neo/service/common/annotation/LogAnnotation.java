package com.xsw.neo.service.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解  通过aop切面实现自定义注解
 *
 * @author xueshengwen
 * @since 2021/7/19 10:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    boolean isPrintLog() default true;
}
