package day0306.hw01;

public class Exercise4 {
    public static void main (String[] args){
        int number = 100;
        int result;
        result = number+10;
        System.out.printf("출력형식 : 덧셈 연산의 결과 : %d\n", result);

        result = number-10;
        System.out.printf("출력형식 : 뺄셈 연산의 결과 : %d\n", result);

        result = number*10;
        System.out.printf("출력형식 : 곱셈 연산의 결과 : %d\n", result);

        result = number/10;
        System.out.printf("출력형식 : 나눗셈 연산의 결과 : %d\n", result);
    }
}
