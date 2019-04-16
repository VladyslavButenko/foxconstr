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
            throwing = "e"
    )
    public void afterThrowAdvice(Exception e) {
        logger.error("EXCEPTION HAS BEEN THROWN! " + e.getClass());
    }
}
