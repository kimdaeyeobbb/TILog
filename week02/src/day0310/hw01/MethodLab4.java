package day0310.hw01;

public class MethodLab4 {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, difference = 0;
        for (int i=0; i<5; i++){
            num1 = (int)(Math.random()*30)+1;
            num2 = (int)(Math.random()*30)+1;
            difference = compareValue(num1,num2);
            System.out.printf("%d 와 %d 의 차는 %d 입니다.\n" , num1, num2, difference);
        }
    }

    static int compareValue(int x, int y){
        if (x==y){
            return 0;
        } else {
            return Math.abs(x-y);
        }
    }
}
