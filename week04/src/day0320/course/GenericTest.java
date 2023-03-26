package day0320.course;

import java.util.Iterator;
import java.util.LinkedList;

public class GenericTest {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// 타입 매개변수를 주지않았으므로 타입은 자동으로 Object로 설정됨

		list.add("java");
		list.add(100);
		// String으로 바뀔 수 없는 것을 String으로 바꾸려고 해서 에러 발생
		// 만약, 위에서 타입 매개변수를 Object 형이 아닌 String형으로 설정시 여기서 바로 에러가 남

		list.add("servlet");
		list.add("jdbc");

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();

		for (Object value : list) {
			String s = (String) value;
			System.out.println(s);
		}
		System.out.println();

		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object value = iter.next();
			String s = (String) value;
			System.out.println(s);
		}
	}
}
