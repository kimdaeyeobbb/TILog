package day0314.course;

class MyObject {
    void printName(){
        System.out.println("자바듀크");
    }
    public String toString(){
        return "Object의 자식클래스인 MyObject 객체임";
    }
}

public class MyObjectTest {
    public static void main(String[] args) {
        MyObject my = new MyObject();
        System.out.println(my.toString());  // day0314.course.MyObject@6a5fc7f7 (클래스명@참조값)
    // 조상이 가지는 멤버들 대부분 자손에게 내려진다. (상속) (단, private형 멤버는 부모것이므로 상속되지 않음)
        // 상속받으면 자손이 자기것처럼 사용할 수 있음
        // 자바에서 만들어지는 모든 클래스는 Object의 자손이다.

        System.out.println(my);
        System.out.println("my : "+my);

        my.printName();
        // 얘는 호출만 할 수 있음. 리턴값이 없는 애임.
        // 클래스에 있는 메서드와 조상으로부터 물려받은 메서드등을 사용할 수 있다
        // 조상으로부터 물려받은것도 MyObject의 멤버가 됨
    }
}
