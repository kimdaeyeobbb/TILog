package day5.hw;

public class MethodLab3 {
    public static void main(String[] args) {
        String result = (isEven(10)== true) ? "짝수" : "홀수";
        System.out.println("10은 " + result+ " 입니다.");

        result = (isEven(13)== true) ? "짝수" : "홀수";
        System.out.println("13은 " + result + " 입니다.");
    }

    static boolean isEven(int num){
        boolean result = (num%2 == 0) ? true : false;
        return result;
    }
}
