package com.dkv.configuration.log4j2;

public enum LoggerType {
    INFO("infoLogger"),
    ERROR("errorLogger"),
    DEBUG("debugLogger"),
    PERFORMANCE("performanceLogger");

    private String value;

    LoggerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
