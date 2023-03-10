package day0310.hw01;

public class MethodLab5 {

    /* 메서드 생성 */
    public static int getRandom(int n){
        int randNum = (int)(Math.random()*n)+1;
        return randNum;
    }
    public static int getRandom(int n1, int n2){
        int randNum2 = (int)(Math.random()*(n2-n1)+1)+n1;
        return randNum2;
    }

    public static void main(String[] args) {
        String result1 = "";
        String result2 = "";
        for (int i=0; i<5; i++){
            if (i<4){
                result1 += getRandom(10) + ", ";
                result2 += getRandom(10,20) + ", ";
            } else {
                result1 += getRandom(10);
                result2 += getRandom(10,20);
            }
        }
        System.out.println(result1);
        System.out.println(result2);
    }

}