package com.dkv.exception;

public class DkvException extends Exception{
    public DkvException(String errorMessage) {
        super(errorMessage);
    }

    public DkvException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public DkvException() {
        super();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
