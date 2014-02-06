/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *
 * @author Deni Husni FR
 */
@Aspect
public class ServiceLog {

    private static final Logger LOGGER = Logger.getLogger(ServiceLog.class);

    @Before("execution(* com.inkubator.*.service.impl.*.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        LOGGER.info(" ---------- Service Executed  ----------");
        LOGGER.info("BEFORE Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("BEFORE Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- Service Executed ----------");
    }

    @Before("execution(* com.inkubator.*.dao.impl.*.*(..))")
    public void logBeforeDao(JoinPoint joinPoint) {
        LOGGER.info(" ---------- DAO Executed  ----------");
        LOGGER.info("BEFORE Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("BEFORE Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- DAO Executed ----------");
    }

    @AfterReturning(pointcut = "execution(* com.inkubator.*.service.impl.*.*(..))",
            returning = "result")
    public void logAfterReturnService(JoinPoint joinPoint, Object result) {
        LOGGER.info(" ---------- Service Executed  ----------");
        LOGGER.info("AFTER Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("AFTER Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- Service Executed  ----------");
    }

}