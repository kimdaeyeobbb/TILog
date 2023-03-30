package day14.course;


abstract class Test {
    Test() {
        System.out.println("No Argument sample");
    }

    abstract void output(String s);
}

public class InnerTest3 {
    void pr(Test o) {  // pr 호출하려면 Test를 전달해야함.
        // Test는 추상클래스임.
        // 따라서 얘를 전달할 얘를 생성해야 함
        o.output("Test");
    }

    public static void main(String args[]) {
        System.out.println("Main start !!");
        InnerTest3 n = new InnerTest3();  // 객체 생성하여 pr을 전달할 것임
        n.pr(new Test() {
            // anaonymouse inner local class를 생성
            // 어떤 클래스/인터페이스를 대신해서 만들것이냐에 따라 대신해서 만들것을 앞에 붙여줌.
            // 누구에 대한 객체 생성하는식을 앞에 붙이냐에 따라서 누구를 상속하느냐가 정해짐. -> Test를 상속하게 됨
            // new Test()를 통해 Test 클래스의 자식이 됨.
            // 어떤 클래스/인터페이스를 상속하느냐에 따라서 new 생성자() 호출식을 지정
            // 매개변수 pr에 객체 전달
            // output 호출하면서 Test를 전달하고 있음
            // 이름없는 inner local의 부모가 Test임
            // 이름없는 얘도 클래스이므로 생성자를 가지고 있음 -> 부모의 생성자 호출

            int su = 100;



            // output 메서드를 오버라이딩
            // 추상 메서드 (미완성 메서드)를 오버라이딩해야 함
            public void output(String s) {
                System.out.println("Anonymous Class : " + s);
                System.out.println("Anonymous Class : " + su);
            }
        });
    }
}
