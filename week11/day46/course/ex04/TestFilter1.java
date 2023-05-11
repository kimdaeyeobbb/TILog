package com.example.springedu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//http://localhost:8088/hello 입력해서 콘솔창 확인


@Component // 객체 생성해서 역할을 초기화하지 않도록 만듦. // log 테스트시에는 log에만 집중하지 위해서 주석으로 막음
// 스프링이 관리하게 만들기 위해 @Component 설정
@Slf4j
@Order(2)  // 이 필터의 순서가 2번쨰로 실행되게 설정한 것
public class TestFilter1 implements Filter {  // Filter 인터페이스를 구현하도록 만들어야 함
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        log.info("[필터1] 요청 자원 수행 전");  // info 메서드를 사용하여 info level로 알려줌
        chain.doFilter(request, response);
        log.info("[필터1] 요청 자원 수행 후");
    }
}
