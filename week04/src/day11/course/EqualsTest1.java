package day11.course;

import java.util.Scanner;

public class EqualsTest1 {
	public static void main(String[] args) {
		String s1 = "가나다";
		String s2 = "가나다";
		String s3 = new String("가나다");  // 내용과 관련없이 String 객체가 무조건 생김. 각각에 대한 String 객체가 생김
		String s4 = new String("가나다");  // 내용과 관련없이 String 객체가 무조건 생김. 각각에 대한 String 객체가 생김

		System.out.println(s1 == s2);
		// true. 하나의 String 객체를 공유하는지 묻는 것.
		// 자바 프로그램상 리터럴이 같으면 객체가 하나만 생성되어 재사용 됨

		System.out.println(s3 == s4);
		// 내용과 관련없이 String 객체가 무조건 생김. 각각에 대한 String 객체가 생김

		System.out.println(s3.equals(s4));
		// s3가 참조한 String 객체의 내용과 s4가 참조한 String 객체의 내용이 동일한지 묻는 것
		// 객체가 참조하는 내용이 같은지 확인하려면 equals를 이용

		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String inputStr = scan.next();
		if(inputStr.equals(s1)) 
			System.out.println("\"가나다\"를 입력했군요...");
		else 
			System.out.println("\"가나다\"가 아니군요...");
		scan.close();
	}
}
