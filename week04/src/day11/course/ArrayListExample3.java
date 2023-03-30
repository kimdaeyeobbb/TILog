package day11.course;

import java.util.ArrayList;

class ArrayListExample3 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		int index1 = list.indexOf("사과");  // indexOf: 앞에서부터 인덱스를 찾음
		int index2 = list.lastIndexOf("사과");  // lastIndexOf: 뒤에서부터 인덱스를 찾음
		// 존재하지 않으면 -1을 리턴

		System.out.println("첫번째 사과: " + index1);
		System.out.println("마지막 사과: " + index2);
	}
}
