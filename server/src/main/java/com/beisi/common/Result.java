package com.beisi.common;

import lombok.Data;

/**
 * 结果封装类
 */

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    private Result(){}
    private Result(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功返回
    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    // 失败返回
    public static <T> Result<T> error(){
        return new Result<>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(), null);
    }

}