package day18.course;

import java.util.stream.Stream;

public class StreamExample6 {

	public static void main(String[] args) {
        /* 여기부터 끝까지가 한 명령임 */
		Stream.of("3", "1", "4", "2", "5", "5")
                //스트림 객체 생성
        .map(x -> {
            // 매개변수 X: 스트림 객체가 가지고 있는 요소를 받음
            System.out.println("시작");
            System.out.println("map : " + x);
            return Integer.parseInt(x);
        })
        .filter(x -> {
            // filter => 리턴값 유형: boolean형
            System.out.println("filter : " + x);
            return x > 1;
        })
        .forEach(x -> {
            System.out.println("forEach : " + x);
        });
	}
}
