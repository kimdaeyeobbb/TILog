package day0306.hw01;

public class Exercise2 {
    public static void main (String[] args){
        int num1 = 35;
        int num2 = 10;
        int quotient = (num1/num2);
        int remainder = num1%num2;

        System.out.printf("%d를 %d 으로 나눈 결과 몫은 %d 이고 나머지는 %d 입니다.", num1,num2,quotient,remainder);
    }
}
