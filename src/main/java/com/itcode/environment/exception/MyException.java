package com.itcode.environment.exception;

/**
 * @Author:wx
 * @Date:2018/12/14 14:56
 */
public class MyException extends Exception {
    public MyException(String msg){
        super(msg);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
    public MyException(String msg, Throwable cause) {super(msg, cause);}
}
