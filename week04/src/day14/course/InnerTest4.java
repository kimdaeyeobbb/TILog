package day14.course;


interface Testable {
    final static String FS = "Interface Test"; // 상수 (값과 메모리 공간을 고정함)

    abstract void output(String s);
}

public class InnerTest4 {
    void pr(Testable o) {
        o.output("Test");
        System.out.println(Testable.FS);
        // System.out.println(o.su); // 자손에서 추가된 멤버는 접근할 수 없다.
    }

    public static void main(String args[]) {
        System.out.println("Main start !!");
        InnerTest4 n = new InnerTest4();
        // 이 이름 없는 Inner 클래스는 Testable 와 Object 의 자손이 된다.
        n.pr(new Testable() {
            // 이름없는 inner local class는 한번만 생성이 가능함
            // new 다음에 인터페이스에 대한 객체 생성식이 나옴
            // 이 객체 생성식을 통해 Testable을 추가상속하는 클래스가됨.
            // (추상 메서드와 추상 클래스는 new 키워드로 생성자 생성할 수 없음)
            // 이 inner local class의 부모는 자동으로 Object이 됨 + Testable을 추가 상속하게 됨
            // extends절을 생략하면 자동으로 Object이 부모가 됨
            int su = 100; // 멤버변수

            /* 외부 클래스의 메서드 오버라이딩 */
            // 이름 없는 inner local class를 추상메서드로 만들 수 없음
            // 얘는 인터페이스니까 생성자는 정의할 수 없음.
            // 자손의 객체를 조상유형의 변수에 전달할 수 있지만 조상 유형의 변수로 자손에 추가된것에 접근을 할 수는 없음
            public void output(String s) {
                // 얘는 구현안하면 에러남
                System.out.println("Anonymous Class : " + s);
                System.out.println("Anonymous Class : " + su);
            }
        });
    }
}
