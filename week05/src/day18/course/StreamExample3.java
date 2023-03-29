package day18.course;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample3 {
	public static void main(String[] args) {
		String[] strArray = { "둘리", "또치", "도우너" };
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.println(item  + " 회원님~~ "));
		System.out.println();

		// int 스트림
		// 정수형 숫자에 특화된 스트림

		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.println(item*item));
		System.out.println();
	}
}