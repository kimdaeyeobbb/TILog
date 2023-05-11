package com.example.springedu.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice  // 전역적으로 에러 처리
public class CommonExceptionHandler {
    @ExceptionHandler(RuntimeException.class)  // RuntimeException
    private ModelAndView errorModelAndView(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("commonErrorPage");
        modelAndView.addObject("msg", "RuntimeException은 내가 다 잡는다!!!" );
        modelAndView.addObject("exceptionInfo", ex );
        return modelAndView;
    }
}

