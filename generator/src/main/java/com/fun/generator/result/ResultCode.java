package com.fun.generator.result;



/**
 * Created by DJun on  2019/07/19 11:56
 * desc:
 */
public enum ResultCode implements IErrorCode{

    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "无相关权限");

    private int code;
    private String message;

    ResultCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
