package week11.day46.course.ex04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)  // 주석으로 막아서 아무 영향력이 없게 만듦
@ComponentScan(basePackages = {"com.example.springedu", "thymeleaf.exam"})
@MapperScan(value={"com.example.springedu.dao"})
public class SpringeduApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringeduApplication.class, args);
	}
}