package com.dkv.configuration.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTraceInterceptor {

    Logger logger = LogManager.getLogger(LoggerType.PERFORMANCE.getValue());

    @Around("@annotation(com.dkv.configuration.log4j2.PerformanceLogAudit)")
    public Object intercept(final ProceedingJoinPoint point) throws Throwable {
        String fullyQualifiedClassName = point
                .getSignature().getDeclaringType().getName();
        String methodName = point.getSignature().getName();
        logger.info(String.format("Execution in %s %s()", fullyQualifiedClassName, methodName));
        return point.proceed();
    }
}
