package day0316.course;

public class TimeTest { 
      public static void main(String[] args) { 
            Time t = new Time(12, 35, 30); 
            System.out.println(t); 
            t.hour = 30;
            System.out.println(t); 
            t.minute = -10;
            System.out.println(t); 
      } 
}

class Time {
      /* 멤버변수 */
      // static 설정 X -> Time 클래스의 객체 만들때마다 달라져야하므로
      // 외부에서 접근이 허용됨 -> 메서드를 통해 접근이 가능하도록 수정 (메서드에서는 설정하려는 값이 유효범위인지 체크 -> 유효범위라면 값 설정이 가능하게 만듦. 아니면 값 설정 못하게 만듦)
      int hour; 
      int minute; 
      int second; 

      /* 인자가없는 생성자가 없으므로 상속시 super가 필요함 */
      Time(int hour, int minute, int second) { 
            this.hour = hour; 
            this.minute = minute; 
            this.second =second; 
      } 

      public String toString() { 
    	  return String.format("%d시 %d분 %d초", hour, minute, second); // System.out.printf() - 화면으로 출력
      } 
} 