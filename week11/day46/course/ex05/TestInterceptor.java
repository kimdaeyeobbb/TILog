package com.example.springedu.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TestInterceptor implements HandlerInterceptor {
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("[인터셉터] preHandle 수행");
        return true;   // return true를 해주어야 컨트롤러가 수행 (false면 인터셉터까지만 수행하고 컨트롤러를 수행하지 않음)
    }

    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        log.info("[인터셉터] postHandle 수행");
    }

    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception{
        log.info("[인터셉터] afterCompletion 수행");
    }
}
