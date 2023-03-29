package day18.course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample2 {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Product product = new Product(i, "상품" + i, "멋진회사", (int) (10000 * Math.random()));
			list.add(product);
		}

		// 객체 스트림 얻기
		Stream<Product> stream = list.stream();
		stream.forEach(p -> System.out.println(p));
		// forEach가 각 요소마다 처리할 람다식을 전달
		// 익명식을 전달
		// toString 메서드가 오버라이딩 되어 있음

		stream.forEach(p -> System.out.println(p.getName()));


		System.out.println("-----------------------------------------------------");
		stream = list.stream();
		stream.forEach(System.out :: println);
	}
}