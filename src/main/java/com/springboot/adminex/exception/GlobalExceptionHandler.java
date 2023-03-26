package com.springboot.adminex.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//测试异常处理器
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handlerException(Exception e) {
        log.info("出现异常{}", e);
        return "login";
    }
}
