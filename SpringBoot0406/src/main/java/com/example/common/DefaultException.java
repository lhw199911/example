package com.example.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lhw199911
 * @Date: 2024/05/03/17:40
 * @Description:
 */
@RestControllerAdvice
public class DefaultException {

    @ExceptionHandler
    ResultJson DefaultExceptionHandler(Exception e) {
        e.printStackTrace();
        return ResultJson.failed("系统异常，请联系管理员");
    }
}
