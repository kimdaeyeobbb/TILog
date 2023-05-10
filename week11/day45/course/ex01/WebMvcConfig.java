package week11.day45.course.ex01;

import com.example.springedu.interceptor.TestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration  // 인터셉터와 관련된 설정을 담고 있음 (당장은 수행되지 않도록 주석처리 해놓음)
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/hello");

        /*
        registry.addInterceptor(인터셉터객체)
                .addPathPatterns("/*") -  모든 Path 적용
                .addPathPatterns("/sample") - /sample Path 에 대해서만 적용
                .excludePathPatterns("/sample"); - /sample Path 에 대해서만 제외
        */
    }
}
