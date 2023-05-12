package com.example.springedu.config;

import com.example.springedu.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 인터셉터와 관련된 설정을 담고 있음 (주석처리 해놓으면 => 당장은 수행되지 않음)
public class WebMvcConfig implements WebMvcConfigurer {
    @Override // 오버라이딩해서 인터셉터를 등록 해줌
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())    // 등록하고 싶은 인터셉터를 등록
                .addPathPatterns("/hello");  // 클라이언트가 어떤 컨트롤러를 호출했을 떄 인터셉터가 수행되도록 하는지를 설정함

        /*
        registry.addInterceptor(인터셉터객체)   // 등록하고 싶은 인터셉터 객체
                .addPathPatterns("/*") -  모든 Path 적용
                .addPathPatterns("/sample") - /sample Path 에 대해서만 적용
                .excludePathPatterns("/sample"); - /sample Path과 관련된 컨트롤러에 대해서만 제외 (이외의 모든 요청은 수락)
        */
    }
}
