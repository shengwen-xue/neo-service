package com.xsw.neo.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xueshengwen
 * @since 2021/7/13 16:19
 */
@Aspect
@Slf4j
@Component
public class LogAspectHandler {

    /**
     * 第一种方式：通过表达式实现拦截包的切面
     * 定义一个切面，拦截com.xsw.neo.service.controller包和子包下的所有方法
     * 表达式的第一个*表示返回值类型为所有类型
     * 包名：需要拦截的包、子包下所有类的方法
     * 第二个* 表示该包下的所有类和方法
     * 第三个*(..) 表示方法参数，两个点表示为任何参数
     */
    @Pointcut(value = "execution(* com.xsw.neo.service.controller..*.*(..))")
    public void pointCut() {

    }

    /**
     * 第二种方式：通过注解实现使用该注解才执行切面
     */
//    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void annotationCut(){
//
//    }

    /**
     * 在上面定义的切面方法之前执行该方法
     *
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("开始执行before方法");
        // 获取签名
        Signature signature = joinPoint.getSignature();

        // 获取切面的包名
        String declaringTypeName = signature.getDeclaringTypeName();

        // 获取即将执行的方法名
        String methodName = signature.getName();

        log.info("即将执行的方法：{}，该方法属于包：{}", methodName, declaringTypeName);

        // 获取请求的URL和IP地址
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 获取请求的URL
        String url = request.getRequestURI();
        // 获取请求的IP地址
        String ip = request.getRemoteAddr();
        log.info("用户请求的Url：{}，IP地址：{}", url, ip);
    }

    /**
     * 在上面定义的切面方法之后执行该方法
     *
     * @param joinPoint
     */
    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("开始执行after方法");
        // 获取签名
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        log.info("请求的方法：{} 已结束", methodName);
    }


    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取执行的方法名
        String methodName = signature.getName();

        log.info("请求的方法：{} 已结束，返回值：{}", methodName, result);
    }

    /**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     *
     * @param joinPoint
     * @param throwable
     */
    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取执行的方法名
        String methodName = signature.getName();

        log.info("请求的方法：{} 已结束，异常为：{}", methodName, throwable);
    }
}
