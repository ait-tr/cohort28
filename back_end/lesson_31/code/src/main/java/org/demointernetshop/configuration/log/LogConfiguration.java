package org.demointernetshop.configuration.log;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogConfiguration {
    @Pointcut("execution (public *  org.demointernetshop.controllers.*.*(..))")
    public void logForControllers(){}

    @Pointcut("execution (public *  org.demointernetshop.services.*.*(..))")
    public void serviceLog(){}

    @Before("logForControllers()")
    public void beforeUsingAnyController(JoinPoint point){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        log.info("""
                    RECEIVED REQUEST:
                     IP: {}
                     HTTP METHOD: {}
                     URL: {}
                     """,
                request.getRemoteAddr(),
                request.getMethod(),
                request.getRequestURI().toString());

    }

    @Before("serviceLog()")
    public void diBeforeServiceLog(JoinPoint joinPoint){
        log.info("RUN Service: \n SERVICE_METHOD: {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
    }

    @AfterThrowing(throwing = "exception", pointcut = "logForControllers()")
    public void throwException(JoinPoint joinPoint, Exception exception) {
        log.error("Request throw an exception. Cause - {}.{}",
                Arrays.toString(joinPoint.getArgs()), exception.getMessage());
    }
}
