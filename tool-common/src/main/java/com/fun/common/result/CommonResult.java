package com.fun.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by DJun on  2019/07/19 11:49
 * desc:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    /**
     * 成功
     *
     * @param data 传入数据
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功
     * 自定义提示信息
     * @param data 传入数据
     * @param message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败
     * 自定义错误
     * @param errorCode 错误
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    /**
     * 失败
     */
    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /**
     * 失败
     * 自定义提示信息
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<>(ResultCode.FAILED.getCode(),message,null);
    }

    /**
     * 参数验证失败
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败
     * 自定义提示信息
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }

    /**
     * 未登录
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

}
