package com.xsw.neo.service.handler;

import com.google.zxing.NotFoundException;
import com.xsw.neo.service.common.exception.CommonException;
import com.xsw.neo.service.common.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理类
 *
 * @author xueshengwen
 * @since 2021/7/14 15:50
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultBody handleHttpMessageNotReadableException() {
        return ResultBody.FAIL("缺少必要的请求参数");
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResultBody handleNotFoundException() {
        return ResultBody.FAIL("找不到请求路径");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBody handleTypeMismatchException() {
        return ResultBody.FAIL("空指针异常");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBody handleException() {
        return ResultBody.FAIL("系统发生异常");
    }

    @ExceptionHandler(CommonException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBody handleCommonException(CommonException commonException) {
        return ResultBody.FAIL(commonException.getMessage());
    }
}
