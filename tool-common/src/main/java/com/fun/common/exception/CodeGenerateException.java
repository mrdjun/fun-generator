package com.fun.common.exception;

/**
 * 生成代码如遇问题抛异常
 * @author DJun
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
