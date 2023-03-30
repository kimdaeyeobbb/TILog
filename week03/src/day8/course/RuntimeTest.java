package day8.course;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();  // 팩토리 메서드 -> 객체를 만들어주는 메서드 -> 객체를 1번만 만들 수 있도록 설계되어 있음
        // 객체 생성시 우리가 일반적으로 알고있는 Runtime r = new Runtime(); 꼴로 생성할 수 x
        // constructor가 invisible (private 설정되어서 감춰진 것) (모든 클래스는 최소 1개의 생성자가 존재)
        // 따라서 생성자를 통해 객체생성을 할수는 없고 일반 메서드를 통해 객체 생성을 함.
        // Runtime 클래스 내의 static형은 getRuntime안해도 호출 가능

        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();

        System.out.println(r);
        System.out.println(r1);
        System.out.println(r2);
        r.exec("c:/windows/notepad.exe");  // 메모장 기동
    }
}
