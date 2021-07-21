package com.xsw.neo.service.common.annotation;

import java.lang.annotation.*;

/**
 * @author xueshengwen
 * @since 2021/7/19 17:10
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME) // 该注解的生命周期
public @interface ExportAnnotation {
}
