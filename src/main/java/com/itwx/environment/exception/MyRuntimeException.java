package com.itwx.environment.exception;

/**
 * @Author:wx
 * @Date:2018/12/14 14:56
 */
public class MyRuntimeException extends Exception {
    public MyRuntimeException(String msg){
        super(msg);
    }

    public MyRuntimeException(Throwable cause) {
        super(cause);
    }
    public MyRuntimeException(String msg, Throwable cause) {super(msg, cause);}
}
