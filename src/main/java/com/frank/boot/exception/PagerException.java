package com.frank.boot.exception;

public class PagerException extends Exception {
    //无参构造方法
    public PagerException(){

        super();
    }

    //有参的构造方法
    public PagerException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public PagerException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public PagerException(Throwable cause) {

        super(cause);
    }

}
