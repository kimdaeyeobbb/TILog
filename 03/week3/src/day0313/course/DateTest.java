// 패키지선언 -> import 선언 -> 클래스 정의 순서대로 진행해야 함
package day0313.course;
import java.util.Date;  // 얘를 쓰겠다는것을 미리 명시


public class DateTest {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today.toString());   // 하나의 문자열로 리턴
        System.out.println(today.toLocaleString());
    }
}
