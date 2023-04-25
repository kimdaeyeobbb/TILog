package com.example.springedu.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@AllArgsConstructor 	// 롬복 -> 모든 멤버변수의 값을 생성자자 하나가 받게하는 생성자 함수를 만들라는 것
public class StepVO {  // 도메인 객체의 멤버변수와 이름을 맞춰주어야 함
	private String name;
	private String phoneNumber;
	private int age;
}
