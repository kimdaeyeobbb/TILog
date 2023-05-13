package com.example.springedu.aop;

/* /hello 요청시 요구사항에 맞는 출력하는 before와 after advice mehtod를 구현 */
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLab1 {

    @Before("execution(* com.example.springedu.controller.HelloController.hello(..))")
    public void beforeHello() {
        System.out.println("[AOP]hello 수행전");
    }

    @After("execution(* com.example.springedu.controller.HelloController.hello(..))")
    public void afterHello() {
        System.out.println("[AOP]hello 수행후");
    }
}