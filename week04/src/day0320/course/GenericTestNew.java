package day0320.course;

import java.util.Iterator;
import java.util.LinkedList;

public class GenericTestNew {
	public static void main(String[] args) {
		// 제네릭스 라는 구문이 적용되어 만들어진 클래스의 객체 생성시
		// 타입 파라미터라는 것을 사용한다.
		LinkedList<String> list = new LinkedList<>(); // 타입파라미터
		list.add("java");
		list.add("100");
		list.add("servlet");
		list.add("jdbc");

		/* 속도가 느림 */
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		// 위에서 컬렉션 객체를 통해 데이터형을 미리 설정해뒀으므로 데이터를 넣을 때 제대로 된 타입의 데이터가 들어가는지 체킹 가능
		System.out.println();

		/* 속도가 빠름. */
		for (String value : list) {
			// 꺼내올 때 바로 String형으로 꺼내오겠다고 설정해놨으므로 바로 꺼내올 수 있었음
			System.out.println(value);
		}
		System.out.println();

		/* 속도가 빠름. 내부에서 iterator사용 */
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
}
