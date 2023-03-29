package day18.course;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample0 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("A", "B", "C", "D");

		/* 스트림 사용 X - Iterator 객체 이용 */
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		System.out.println("-------------------------------");

		/* 스트림 사용 O - 내부 반복자 */
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));

		System.out.println("=================");
		Stream<String> stream2 = list.stream();
		stream2.forEach(System.out::println);
	}

}
