package com.butenko.vladyslav.foxconstructions.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerExceptionAspect {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionAspect.class);

    //TODO add pointcut for controller
    @AfterThrowing(
            pointcut = "execution(* com.butenko.vladyslav.foxconstructions..controller..*(..))",
            throwing = "exception"
    )
    public void afterThrowAdvice(Exception exception) {
        logger.error("EXCEPTION HAS BEEN THROWN! " + exception.getClass());
    }
}
