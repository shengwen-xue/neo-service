//package com.xsw.neo.service.handler;
//
//import com.xsw.neo.service.common.annotation.ExportAnnotation;
//import com.xsw.neo.service.common.annotation.I18nFieldAnnotation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
///**
// * @author xueshengwen
// * @since 2021/7/19 11:21
// */
//@Slf4j
//@Component
//public class MyAnnotationInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("开始执行拦截器...");
//
//        if(!(handler instanceof HandlerMethod)){
//            return true;
//        }
//
//        Method method = ((HandlerMethod) handler).getMethod();
//        ExportAnnotation annotation = method.getAnnotation(ExportAnnotation.class);
//        if(annotation!=null){
//
//        }
//
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }
//}
