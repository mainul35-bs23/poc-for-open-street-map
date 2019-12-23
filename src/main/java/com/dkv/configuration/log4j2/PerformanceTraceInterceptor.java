package com.dkv.configuration.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceTraceInterceptor {

    Logger logger = LogManager.getLogger(PerformanceTraceInterceptor.class);

    @Around("@annotation(com.dkv.configuration.log4j2.PerformanceLogAudit)")
    public Object intercept(final ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;
        logger.info(point.getArgs());
        return point.proceed();
    }
}
