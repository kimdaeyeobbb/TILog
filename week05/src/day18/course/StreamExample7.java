package day18.course;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample7 {

	public static void main(String[] args) {
		String[] fruits = new String[] { "apple", "oranges", "banana", "pineapple", "oranges", "apple", "mango" };
		Stream<String> fruitsStream = Arrays.stream(fruits);

		List<String> newList1 = fruitsStream.filter(x -> x.endsWith("e")).collect(Collectors.toList());
		// collect - 인자를 어떤 타입으로 모을것인지를 지정해줌
		// Collectors.tolist() - 어떤 객체로 collect할 것인지를 인자로 전달. filter를 통과한 애들을 리스트 객체로 모아서 받겠다고 지정한 것
		// 만든 스트림은 여기서 이미 다 소모함


		List<String> newList2 = Arrays.stream(fruits).map(x -> x.toUpperCase()).collect(Collectors.toList());

		System.out.println(newList1);
		System.out.println("-------------");

		// 애들을 하나하나 직접 내보내기 위해 forEach 이용
		for (String e : newList2)
			System.out.println(e);
	}
}