package day0307.hw2;

public class ForLab4 {
    public static void main(String[] args) {
        int evenNum = 0;
        int oddNum = 0;
        for (int n=1; n<=100; n++){
            if (n%2 == 0){
                evenNum += n;
            } else {
                oddNum += n;
            }
        }
        System.out.println("1부터 100까지의 숫자들 중에서");
        System.out.println("짝수의 합은 "+evenNum +" 이고");
        System.out.println("홀수의 합은 "+oddNum +" 이다.");
    }
}
