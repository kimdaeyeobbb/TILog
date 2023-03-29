package day18.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExample9 {
	public static void main(String[] args) {
		// 문장 스트림을 단어 스트림으로 변환
		List<String> list1 = new ArrayList<>();
		list1.add("this is java");
		list1.add("i am a best developer");
		list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(System.out::println);
		// 중간에 스트림 객체를 만들어서 리턴
		// flatMap : 스트림 객체안에 스트림 객체가 또 들어있더라도 1차원으로 평탄화시킴
		// flatMap을 map으로 바꾸면 스트림 객체의 정보가 출력됨

		System.out.println();

		// 문자열 숫자 목록 스트림을 숫자 스트림으로 변환
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream().flatMapToInt(data -> {
			// flatMap
			// ToInt : int형 객체를 리턴
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(number -> System.out.println(number));
	}
}