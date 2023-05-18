package com.example.springedu2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springedu2", "springjpa.exam", "springrest.exam"})  // 어노테이션 정보를 읽어서 초기화하는 것. 컴포넌트 스캔 추가할 것
@EnableJpaRepositories(basePackages = {"springjpa.exam.repository"})
@EntityScan(basePackages = {"springjpa.exam.entity"})
public class Springedu2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springedu2Application.class, args);
	}

}
