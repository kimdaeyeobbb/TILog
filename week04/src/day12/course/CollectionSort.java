package day12.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort {
	public static void main(String[] args) {
		String[] array = { "JAVA", "SERVLET", "JDBC", "JSP", "RMI" };
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, array);
		// addAll -> list에 array의 요소를 넣음

		System.out.println("list에 저장된 모든 데이터 : " + list);

		int index = Collections.binarySearch(list, "JDBC");
		// 주어진 collection 객체 안에 어떤 데이터가 존재하는지 인덱스를 읽어올 수 있음


		System.out.println("\"JDBC\" 가 저장된 위치 : " + index);

		String maxStr = Collections.max(list);
		String minStr = Collections.min(list);
		System.out.println("최대값:" + maxStr);
		System.out.println("최소값:" + minStr);

		Collections.sort(list);
		// sort - 해당 collection 객체를 변화시킴

		System.out.println("list의 데이터들을 오름차순으로 소팅한 결과 : " + list);

		Collections.shuffle(list);
		// 값들을 무작위로 섞는 메서드. collection 객체의 데이터를 랜덤하게 섞음

		System.out.println("list의 데이터들을 섞은 결과 : " + list);

		List<Integer> list2 = new ArrayList<Integer>();
		// Integer 객체를 가지는 list 자료형

		list2.add(10);
		list2.add(20);
		list2.add(15);
		list2.add(5);
		int maxNum = Collections.max(list2);
		int minNum = Collections.min(list2);
		System.out.println("최대값:" + maxNum);
		System.out.println("최소값:" + minNum);

	}
}
