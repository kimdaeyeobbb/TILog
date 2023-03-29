package day2.hw;

public class AlphaTest {
    public static void main(String[] args) {
        int num = (int)(Math.random()*26+1);
//        System.out.println(num);
//        System.out.println('@'+num);
        System.out.println((char)('@'+num));
        // '@' - 아스키코드 번호: 64
        // 'A' - 아스키코드 번호: 65, 'Z' - 아스키코드 번호: 90
    }
}

