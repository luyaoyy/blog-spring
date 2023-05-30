package com.blue.utils;

import com.blue.myenum.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Response<T> success(String msg,T date) {
        return new Response<>(RespBeanEnum.SUCCESS.getCode(), msg, date);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(RespBeanEnum.SUCCESS.getCode(), msg, null);
    }

    public static <T> Response<T> error(String msg) {
        return new Response<>(500, msg, null);
    }

    public static <T> Response<T> error(Integer code, String msg) {
        return new Response<>(code, msg, null);
    }

    public static <T> Response<T> error() {
        return new Response<>(RespBeanEnum.ERROR.getCode(), RespBeanEnum.ERROR.getMessage(), null);
    }
}
