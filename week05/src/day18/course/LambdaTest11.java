package day18.course;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest11 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		// 가변형 인자
		// 데이터 값이 몇개이든 상관없이 리스트로 리턴해달라고 함

		System.out.println("오리지널 리스트 : " + list);


		Collections.sort(list);
		System.out.println("기본은 오름차순 : " + list);

		Collections.sort(list, new Comparator<String>() {
			// 리스트 객체만 가지고 sort시에는 리스트가 오버라이딩 해놓은 compareTo를 가지고 sort 수행
			// 같이 전달된 Comparator 객체가 우선임(기준객체가 됨). 두번쨰 인자인 얘를 가지고 compareTo를 호출.
			// 이 경우 내림차순이 됨


			// String은 Comparable을 추가 상속하고 있음
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s2.compareTo(s1);
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, String::compareTo);
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);
	}
}
