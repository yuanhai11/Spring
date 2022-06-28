package com.wxt.beans.factory;

public class BaseException extends RuntimeException {

    public BaseException(String msg, Throwable cause) {super(msg, cause);}

    public BaseException(String msg) {
        super(msg);
    }
}
