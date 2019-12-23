package com.dkv.configuration.log4j2;


import org.apache.logging.log4j.Logger;

import java.util.Properties;


public class DkvLogManager {

    private final Logger errorLogger;
    private final Logger performanceLogger;
    private final Logger debugLogger;
    private final Logger infoLogger;

    private static DkvLogManager dkvLogManager;

    public DkvLogManager(Properties properties) {
        this.errorLogger = org.apache.logging.log4j.LogManager.getLogger(properties.get("logger.errorLogger.name").toString());
        this.performanceLogger = org.apache.logging.log4j.LogManager.getLogger(properties.get("logger.performanceLogger.name").toString());
        this.debugLogger = org.apache.logging.log4j.LogManager.getLogger(properties.get("logger.debugLogger.name").toString());
        this.infoLogger = org.apache.logging.log4j.LogManager.getLogger(properties.get("logger.infoLogger.name").toString());
        dkvLogManager = this;
    }

    public static DkvLogManager getLogManager() {
        return dkvLogManager;
    }

    public void error(String message) {
        errorLogger.error( message );
    }

    public void error(Exception exp) {
        errorLogger.error( exp );
    }

    public void error(String message, Exception exp) {
        errorLogger.error( message , exp);
    }

    public void performanceLog(String message) {
        performanceLogger.info( message );
    }

    public void performanceLog(Exception exp) {
        performanceLogger.info( exp );
    }

    public void performanceLog(String message, Exception exp) {
        performanceLogger.info( message , exp);
    }

    public void debug(String message) {
        debugLogger.debug( message );
    }

    public void debug(Exception exp) {
        debugLogger.debug( exp );
    }

    public void debug(String message, Exception exp) {
        debugLogger.debug( message , exp);
    }

    public void info(String message) {
        infoLogger.info( message );
    }

    public void info(Exception exp) {
        infoLogger.info( exp );
    }

    public void info(String message, Exception exp) {
        infoLogger.info( message , exp);
    }

}
