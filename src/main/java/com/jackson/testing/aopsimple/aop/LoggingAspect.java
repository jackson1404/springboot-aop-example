/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.testing.aopsimple.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * LoggingAspect Class.
 * <p>
 * </p>
 *
 * @author
 */

@Aspect
@Component
class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.jackson.testing.aopsimple.service.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("[BEFORE] Method: {}", joinPoint.getSignature());
    }

    @After("execution(* com.jackson.testing.aopsimple.service.UserService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[AFTER] Method: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.jackson.testing.aopsimple.service.UserService.getUserById(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("[AFTER RETURNING] Method: {}, Returned: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.jackson.testing.aopsimple.service.UserService.getUserById(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("[AFTER THROWING] Method: {}, Exception: {}", joinPoint.getSignature(), ex.getMessage(), ex);
    }

    @Around("execution(* com.jackson.testing.aopsimple.service.UserService.createUser(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        log.info("[AROUND] Before method: {}", pjp.getSignature());
        Object result = pjp.proceed();
        log.info("[AROUND] After method: {}", pjp.getSignature());
        return result;
    }
}