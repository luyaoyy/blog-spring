package com.blue.exception;

import com.blue.utils.Response;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)//处理参数校验异常
    public Response<?> bindExceptionHandler(BindException e) {
        return Response.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(GlobalException.class)//处理自定义异常
    public Response<?> globalExceptionHandler(GlobalException e) {
        return Response.error(e.getRespBeanEnum().getCode(), e.getRespBeanEnum().getMessage());
    }

    @ExceptionHandler(Exception.class)//处理其他常见异常
    public Response<?> exceptionHandler(Exception e) {
        return Response.error(e.getMessage());
    }


    //    @ExceptionHandler(Exception.class)
//    public Response<?> exceptionHandler(Exception e) {
//        if (e instanceof RuntimeException) {//如果是运行异常
//            GlobalException ex=(GlobalException) e;
//            return Response.error(ex.getRespBeanEnum().getCode(),ex.getRespBeanEnum().getMessage());
//        } else if (e instanceof BindException) {//如果是参数绑定异常
//            BindException ex = (BindException) e;
//            return Response.error(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//        }
//        return Response.error(e.getMessage());
//    }
}
