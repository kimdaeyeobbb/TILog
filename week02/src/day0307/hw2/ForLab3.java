package day0307.hw2;

public class ForLab3 {
    public static void main(String[] args) {
        int randNum1 = (int)(Math.random()*10+1);  // 1~10
        int randNum2 = (int)(Math.random()*11+30);  // 30~40
        int evenSum =0;
        for (int n=randNum1; n<=randNum2; n++){
            if(n%2 == 0){
                evenSum+=n;
            }
        }
        System.out.printf("%d부터 %d까지의 짝수의 합 : %d", randNum1, randNum2, evenSum);
    }
}
