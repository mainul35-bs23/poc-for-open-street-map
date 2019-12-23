package com.dkv.exception;

import com.dkv.configuration.log4j2.LoggerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DkvException extends Exception{
    private Logger logger = LogManager.getLogger(LoggerType.ERROR.getValue());

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
        logger.error(super.getStackTrace());
    }

    @Override
    public String getMessage() {
        logger.error(super.getMessage());
        return super.getMessage();
    }
}
