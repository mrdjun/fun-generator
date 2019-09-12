package com.fun.generator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * created by DJun on 2019/8/10 23:31
 * desc: 结果返回类
 */
@Getter
@Setter
public class ReturnT<T> implements Serializable {

    public static final long serialVersionUID = 42L;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final ReturnT<String> SUCCESS = new ReturnT<String>(null);
    public static final ReturnT<String> FAIL = new ReturnT<String>(FAIL_CODE, null);

    private int code;
    private String msg;
    private T data;

    public ReturnT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ReturnT(T data) {
        this.code = SUCCESS_CODE;
        this.data = data;
    }

}
