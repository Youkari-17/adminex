package com.springboot.adminex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN,reason = "请求用户太多")
public class TooManyUserException extends RuntimeException{

}
