package day0320.course;

import java.util.Date;

public class CreateGenericTest {
    public static void main(String[] args) {
        Value1 v1 = new Value1();
        v1.put("가나다");  // v1은 String 객체만 전달 가능
        String s1 = v1.get();
        System.out.println(s1);

        //v1.put(new Date());  // error
        // String은 final class임. 자손도 못가짐.

        Value2 v2 = new Value2();
        v2.put("리액트");
        //String s2 = v2.get();  // error. 가져올 때 형변환 해야함
        String s2 = (String)v2.get();
        System.out.println(s2);

        //Date d2 = v2.get(); // error. 가져올 때 형변환 해야함
        v2.put(new Date());
        Date d2 = (Date) v2.get();
        System.out.println(d2);

        /* 제네릭 */
        Value3<String> v3 = new Value3<>();
        // 타입 파라미터:  <> 안에 들어가는 타입 정보. 반드시 객체형만 사용해야 함 (기본형 사용불가)
        // v3는 String형을 담을 수 있는 객체
        v3.put("노드");
        String s3 = v3.get();
        System.out.println(s3);


        Value3<Date> v4 = new Value3<>();
        // v4가 참조하는 객체는 Date형 객체
        // 클래스를 다룰 때에는 어떤 타입을 다룰지 고정하지 않게 만들어줌
        // 객체 생성시 타입 파라미터를 어떻게 설정하느냐에 따라 사용시점에서 타입을 결정함
        // 타입 매개변수로 전달되는 형태에 따라 클래스 내부의 <T>는 해당 형태로 모두 바뀜

        v4.put(new Date());
        Date d4 = v4.get();
        System.out.println(d4);


        Value3<Integer> v5 = new Value3<>();
        //v3.put(new Date());
        // error. 집어넣을 떄부터 다른 타입을 허용하지않음.
        // 제네릭 덕분에 타입 파라미터의 위배되는 데이터를 처리하려고 할 떄 컴파일시 이에대한 에러를 미리 체크해서 알려줌
        // 제네릭: 객체 생성시점에 클래스가 다루는 데이터의 타입을 결정
    }
}

class Value1 {
    // Value1은 String 객체만(혹은 String의 자손만) 처리할 수 있음

    String obj;
    void put(String obj){
        this.obj = obj;
    }
    String get() {
        return obj;  // get 메서드 호출시 obj 값을 리턴함
    }
}

class Value2 {
    // Value2 가지고는 어떤 타입의 객체든 저장하고 꺼내고 싶음.
    // 따라서 타입을 Object형으로 설정해주자.
    // Value2는 어떤 타입의 객체든 전달할 수 있음
    // 대신 꺼내올 떄에는 Object형으로 리턴되므로 원하는형으로 형변환해서 가져와야 함


    Object obj;
    void put(Object obj){
        this.obj = obj;
    }
    Object get() {
        return obj;  // get 메서드 호출시 obj 값을 리턴함
    }
}

/* 제네릭 적용 */
// 어떤 타입의 객체든 처리할 수 있게 해줌
// Value2와 달리 받아올 때 형변환을 하지 않아도 됨
// 제네릭은 C#에서 왔다고 한다.
class Value3<T>{
    // T에 뭘 쓰든 무관
    // 객체 생성시 Type 매개변수 하나 받을 것이라는 뜻
    // 타입 매개변수로 전달되는 형태에 따라 클래스 내부의 <T>는 해당 형태로 모두 바뀜
    // 객체를 생성하는 시점에서 입맛에 맞게 어떤 타입의 데이터를 다룰것인지를 결정함
    // 어떤 타입 파라미터를 전달하느냐에 따라 해당 타입에 특화된 클래스를 만드는 것임
    // 클래스에 대한 활용력이 좋아짐 (꺼내올 때 형변환을 하지 않아도 됨)

    T obj;
    // 멤버변수의 타입을 T로 지정

    void put(T obj){
        this.obj = obj;
    }

    T get(){
        return obj;
    }
}