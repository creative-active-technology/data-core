/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.datacore.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Date enterDate;
    private Date escapeDate;

    @Before("execution(* com.inkubator.*.service.impl.*.*(..))")
    public void logBeforeService(JoinPoint joinPoint) {
        enterDate = new Date();
        LOGGER.info(new SimpleDateFormat("dd-MM-yyy hh:mm:ss.SSS").format(enterDate));
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

    @AfterReturning(pointcut = "execution(* com.inkubator.*.dao.impl.*.*(..))",
            returning = "result")
    public void logAfterReturnDao(JoinPoint joinPoint, Object result) {
        LOGGER.info(" ---------- DAO Executed ----------");
        LOGGER.info("AFTER Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("AFTER Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- DAO Executed  ----------");
    }

    @AfterReturning(pointcut = "execution(* com.inkubator.*.service.impl.*.*(..))",
            returning = "result")
    public void logAfterReturnService(JoinPoint joinPoint, Object result) {

        LOGGER.info(" ---------- Service Executed  ----------");
        LOGGER.info("AFTER Methode - Class Name :" + joinPoint.getTarget().getClass().getName());
        LOGGER.info("AFTER Methode - Method Name :" + joinPoint.getSignature().getName() + "()");
        LOGGER.info(" ---------- Service Executed  ----------");
        escapeDate = new Date();
        LOGGER.info(new SimpleDateFormat("dd-MM-yyy hh:mm:ss.SSS").format(escapeDate));
        String start = new SimpleDateFormat("ss.SSS").format(enterDate);
        String end = new SimpleDateFormat("ss.SSS").format(escapeDate);
        Double star1 = Double.parseDouble(start);
        Double end1 = Double.parseDouble(end);
        LOGGER.info("Total time :" + (end1 - star1)+" s");

    }

}
