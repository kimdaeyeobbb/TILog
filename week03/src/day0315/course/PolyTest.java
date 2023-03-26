package day0315.course;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        // Object 클래스는 java.lang 패키지에 있으므로 따로 import 안해도됨
        // java.lang 패키지는 자동으로 import 됨

        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        // 다른 패키지에 있는 클래스를 가져다 쓸 경우 클래스명 앞에 패키지명을 붙여서 사용해도 됨

        printObjectInfo(new java.io.File("c:/Temp"));
        // io 패키지에 있는 클래스. 인자가 없는 생성자는 가지고 있지 않음. 따라서 반드시 인자로 무엇인가를 줘야함
        // OS에 따라 디렉토리 구분자가 다름. 윈도우는 슬래시 나머지는 모두 백슬래시
        // JAVA에서는 OS에 관게없이 슬래쉬를 사용해도 됨. 백슬래쉬를 쓸거면 2번을 써야함 (한번은 이스케이프 문자로 인식하므로)

        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
        // 기본형 데이터(int 형)

        printObjectInfo(3.14);  // java.lang.Double
    }

    // 같은 static이어야 메인메서드에서 호출하기 편함
    // non static 메서드일 경우 객체 생성해야 호출 가능함 (같은 클래스 내에 있어도 객체를 통해서만 호출가능)
    static  void printObjectInfo(Object o){
        // 매개변수 - Object이라는 클래스형의 변수
        // Object 객체를 전닲하겠다는 뜻 (Object 또한 자바의 클래스임. 최상위 클래스.)
        // Object이 가지고 있는 사양까지만 접근 가능 (자손에게 추가된 멤버에 접근이 불가능)

        if (o instanceof String){
            // o에게 전달된 객체가 문자열인지 확인
            // instanceof -> 비교연산자 (true or false)
            System.out.println("문자열 객체가 전달됨 : " + o.toString() + "-" + ((String) o).length());
        } else {
            System.out.println("전달된 객체의 클래스명: " + o.getClass().getName());
            // getClass().getname() -> 실제 전달된 객체가 누구인지 확인 (자주 사용)
        }
    }
}