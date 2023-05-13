package com.example.springedu.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLab2 {
    @Before("execution(* com.example.springedu.controller.MultiController.select_proc())")
    public void beforeSelect(){
        System.out.println("[AOP]select_proc 수행전");
    }

    @After("execution(* com.example.springedu.controller.MultiController.search_proc())")
    public void afterSearch(){
        System.out.println("[AOP]search_proc 수행후");
    }
}
