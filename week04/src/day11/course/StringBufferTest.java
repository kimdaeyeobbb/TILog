package day11.course;

public class StringBufferTest {

	public static void main(String[] args) {		
		StringBuffer buffer = new StringBuffer();
		String str = "자바프로그래밍";
     	buffer.append(str);

        System.out.printf("%s\n", buffer);
        buffer.reverse();
        System.out.printf("%s\n", buffer);
        System.out.printf("길이 : %d\n", buffer.length());
        buffer.append(str);
        buffer.append(str);
        buffer.append(str);
        System.out.printf("%s\n", buffer);
        
        StringBuffer bf1 = new StringBuffer("가나다");
        StringBuffer bf2 = new StringBuffer();
        bf2.append("가나다");
        System.out.printf("%b\n", bf1.equals(bf2));
        // equals는 Object 클래스가 가지고 있는 equals를 각각의 클래스들이 필요에 따라서 오버라이딩함.
        //  String과 달리 String Buffer는 equals를 오버라이딩 하지 않음. 따라서 Object에 있는 equals를 호출.
        // Object에 있는 equals는 등가연산과 같음. 여기서는 각각의 참조값이 다르므로 등가연산 수행시 다를 수 밖에 없다.
        // String Buffer는 String 으로 변환해서 equals를 호출하도록 권장됨
        // doc을 찾아봤을 때 equals가 없다면 Object에 있는 equals를 호출하므로 등가연산과 동일함.

        System.out.printf("%b\n", bf1 == bf2);
        System.out.printf("%b\n", bf1.toString().equals(bf2.toString()));
	}
}