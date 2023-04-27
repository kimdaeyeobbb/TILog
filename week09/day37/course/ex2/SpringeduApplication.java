package week09.day37.course.ex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)  // 주석으로 막아서 아무 영향력이 없게 만듦
@ComponentScan(basePackages = {"com.example.springedu", "thymeleaf.exam"})
public class SpringeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeduApplication.class, args);
	}

}
