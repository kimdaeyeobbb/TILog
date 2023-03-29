package day2.course;


public class RandomTest {

    public static void main(String[] args) {
        double rand = Math.random();  // double형에 담아서 여러번 재활용
        System.out.println(rand);     // 0<= X <1.0
        System.out.println(rand*10);   // 0 <= X < 10.0
        System.out.println(rand*100);  // 0 <= X < 100.0
        System.out.println(rand*6);   // 0 <= X < 6.0
        System.out.println((int)(rand*10));   // 0 <= X <= 9
        System.out.println((int)(rand*100));   // 0 ~ 99
        System.out.println((int)(rand*6));   // 0 ~ 5
        System.out.println((int)(rand*10)+1);   // 1~10
        System.out.println((int)(rand*100)+1);  // 1~100
        System.out.println((int)(rand*6)+1);   // 1~6
        System.out.println((int)(rand*45)+1);   // 1~45
    }

}