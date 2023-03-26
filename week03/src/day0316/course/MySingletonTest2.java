package day0316.course;

class MySingleton2 {
    private static MySingleton2 obj = null; // 클래스 로딩할때 미리 객체생성하지 않음
//    private MySingleton2() {
//    }  // 막아줘야 함

    // getMy 호출시 객체 생성해서 리턴
    // 계속 수행하는 것이 아님. 만들어진 객체를 갖다줌.
    static MySingleton2 getMy() {
        if(obj == null){
            obj = new MySingleton2();
        }
        return obj;
    }

    void printMyName() {
        System.out.println("듀크");
    }
    void printFavoriteFood() {
        System.out.println("갈비");
    }
}
public class MySingletonTest2 {
    public static void main(String[] args) {
        //MySingleton my = new MySingleton(); // error. Visible이 아님과 존재하지 않음은 다름
        MySingleton2 my = MySingleton2.getMy();  // 이 클래스는 객체 생성을 위해 getMy() 메서드를 호출해야 함
        // 팩토리 메서드명은 뭘로 하든 상관없지만 일반적으로 `get인스턴스`라는 이름을 많이씀.
        // 혹은 create땡땡땡으로 작명함
        // MySingleton 객체가 생성된 후 리턴

        my.printMyName();
        my.printFavoriteFood();
        System.out.println(my);  // 전달된 객체의 toString 리턴값 (마이싱글톤이 toString이 없으므로 Object의 toString 호출)
        System.out.println(MySingleton2.getMy());  // 마이싱글톤 객체를 달라고 함
        System.out.println(MySingleton2.getMy());
    }
}
