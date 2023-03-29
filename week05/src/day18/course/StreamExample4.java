package day18.course;

import java.util.stream.IntStream;

public class StreamExample4 {
	public static int sum;

	public static void main(String[] args) {
		// start, end값에 대한 데이터값만 가짐
		// Closed -> end값 포함
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
		
		stream = IntStream.rangeClosed(1, 100);
		stream.forEach(System.out::println);
	}
}