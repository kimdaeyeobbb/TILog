package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class AOPLab3 {

    @Around("within(com.example.springedu.controller.EmpController)")
    public void measureTime(ProceedingJoinPoint jp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        jp.proceed();
        stopWatch.stop();
        log.info(jp.getTarget().getClass().getName()+" - 수행시간(밀리초) - {}", stopWatch.getTotalTimeMillis());
    }
}