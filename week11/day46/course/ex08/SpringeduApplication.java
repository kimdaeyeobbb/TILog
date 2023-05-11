package com.example.springedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)  // 주석으로 막아서 아무 영향력이 없게 만듦
@ComponentScan(basePackages = {"com.example.springedu", "thymeleaf.exam", "springws.exam"}) // springws.exam등의 내부에 작성된 어노테이션을 스캐닝해서 빈으로 등록하게 만드는 작업
@MapperScan(value={"com.example.springedu.dao"})
public class SpringeduApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringeduApplication.class, args);
    }
}