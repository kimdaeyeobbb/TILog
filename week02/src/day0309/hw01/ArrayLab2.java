package day0309.hw01;

public class ArrayLab2 {
    public static void main(String[] args) {
        int[] intArr = new int[10];

        for (int i=0; i<intArr.length; i++){
            int randNum = (int)(Math.random()*17)+4;
            intArr[i] = randNum;
        }

        String allEl = "모든 원소의 값 : " + intArr[0];
        int sum = intArr[0];

        for (int i=1; i<intArr.length; i++){
            allEl += ","+intArr[i];
            sum += intArr[i];
        }

        System.out.println(allEl);
        System.out.printf("모든 원소의 합 : %d", sum);
    }
}
