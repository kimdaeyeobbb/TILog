package day0320.course;

import java.util.ArrayList;

class ArrayListExample1 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		// 반드시  String형 데이터를 저장해야 함

		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		// int형은 자동으로 auto boxing에 의해 Integer 객체형으로 변환됨

		list2.add(Integer.valueOf(100));
		list2.add(1000);
		// JDK 1.5 부터 AUTO Boxing 이라는 구문이 지원
		// int형은 자동으로 auto boxing에 의해 Integer 객체형으로 변환됨

		// list2.add("1000");
	}
}
