package day0320.course;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample2 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		// add: 맨 마지막에 삽입

		System.out.println(list);
		list.add(2, "키위");
		// 리스트.add(인덱스, 집어넣을 요소)

		System.out.println(list);

		list.set(0, "오렌지");
		// set: 바꿔치기
		// 0번째 요소를 오렌지로 바꿈

		System.out.println(list);

		list.remove(1);
		// 2번쨰 데이터 삭제


		System.out.println(list);

		list.remove("키위");
		// 키위 삭제 (remove는 인덱스 혹은 실제 값을 넣어저 지울 대상을 선정할 수 있음)

		System.out.println(list);

		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
		for (String fruit : list)
			System.out.println(fruit);
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

	}
}
