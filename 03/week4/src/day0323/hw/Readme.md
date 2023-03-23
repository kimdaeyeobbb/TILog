# 과제1

```java
package day0323.hw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnnonyInnerLab {
    public static void main(String[] args) {
        // 객체 생성
        ArrayList<Book> al = new ArrayList<>();

        // Book 객체 넣어줌
        al.add(new Book("자바의 정석","남궁성",27000));
        al.add(new Book("챗GPT","반병현",11700));
        al.add(new Book("스타트 스프링 부트","남가람",27000));
        al.add(new Book("Doit! 자바프로그래밍","박은중",22500));
        al.add(new Book("이것이 자바다","신용권,임경균",36000));

        for (Book el: al) {
            System.out.println(el.getBookInfo());
        }

        // 타입 파라미터로 Book을 안주면 자동으로 Object이 적용됨.
        Collections.sort(al, new Comparator<Book>() {
                    // anonymouse inner class 를 넣어줌
                    // Book 클래스는 Comparable을 추가 상속하지 않으므로 sort 호출하면서 해당 객체들을 비교하는 기준을 정의한 비교자 역할을 하는 객체를 같이 전달해야함
            // 이것을 자손으로 만들어서 전달함
            // Comparator의 자손을 만들 때 이름이 있는 자손을 만들어도 되지만 실습에서는 익명을 요구함
            // Comparator도 제네릭스가 적용됨.
            // 타입 파리미터를 객체의 클래스명인 Book으로 지정함
            // Comparator 객체 뒤에는 Book을 써주었으므로 Book객체를 비교함.
            // 이로인해 매개변수를 Book형으로 정의해야 함
                    @Override
                    public int compare(Book o1, Book o2) {
                        // 2개의 인자로 전달된 Book 객체
                       return o1.getPrice()-o2.getPrice();
                    }
            }
        );
        System.out.println("[소팅 후 ]");
        for (Book el: al){
            System.out.println(el.getBookInfo());
        }
    }
}

```

- 좋은 아이디어

```java
@Override
public int compare(Book o1, Book o2) {
    // 2개의 인자로 전달된 Book 객체
   return o1.getPrice()-o2.getPrice();
}
```

- sort
  - -1,0,1을 뽑아내는게 중요한게 아니라 음,양 판단을 위한것인데 그것 대신 두 인자의 차이값을 리턴함으로서 크기 비교를 할 수 있음.

