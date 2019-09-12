package com.fun.generator.core.exception;

/**
 * created by DJun on 2019/8/10 23:24
 * desc: 生成代码如遇问题抛异常
 */
public class CodeGenerateException extends RuntimeException {
    private static final long serialVersionUID = 42L;

    public CodeGenerateException(String msg) {
        super(msg);
    }

    public CodeGenerateException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CodeGenerateException(Throwable cause) {
        super(cause);
    }

}
