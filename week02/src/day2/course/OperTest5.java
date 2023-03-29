package day2.course;

public class OperTest5 {
    public static void main(String[] args) {
        int num = (int)(Math.random() * 10) + 1; // 1~10
        char result = num % 2 == 1 ? '홀' : '짝';
        System.out.println(num+"은 "+result+"수입니다.");
// char으로 타입지정을 해주었으므로 문자열대신 문자열을 써야함 (단일 인용부호 사용)

        System.out.println(num+"은 "+(num % 2 == 1 ? '홀' : '짝')+"수입니다.");
    }
}