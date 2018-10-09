package com.maoniya.restful.api.security.web.controller;

import com.maoniya.restful.api.security.model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * date:  Created in 2018/9/28 16:30
 *
 * @author maoning
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseModel exceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
