package day18.course;

import java.util.ArrayList;
import java.util.List;

public class StreamExample8 {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("둘리");
		list.add("또치");
		list.add("도우너");
		list.add("희동이");
		list.add("고길동");
		list.add("또치");
		list.add("도우너");

		// 중복 요소 제거
		list.stream().distinct().forEach(System.out::println);
		// distinct : 중복되는 애들을 걸러낸 결과를 내보냄
		System.out.println();


		list.stream().filter(n -> n.startsWith("고")).forEach(n -> System.out.println(n));
		// 고로 시작하는 요소만 필터링
		System.out.println();


		list.stream().distinct().filter(n -> n.startsWith("도")).forEach(n -> System.out.println(n));
		// 중복 요소를 먼저 제거하고, 도로 시작하는 요소만 필터링
	}
}