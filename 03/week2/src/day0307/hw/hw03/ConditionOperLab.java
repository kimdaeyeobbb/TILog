package day0307.hw.hw03;

public class ConditionOperLab {
    public static void main(String[] args) {
        int randNum = (int)(Math.random()*5+1);
//        System.out.println(randNum);
        int result = 0;
        if (randNum == 1){
            result = (300+50);
        } else if (randNum == 2){
            result = (300-50);
        } else if (randNum == 3){
            result = (300*50);
        } else if (randNum == 4){
            result = (300/50);
        } else if (randNum == 5){  // else문으로 처리해도 됨 (애초에 1~5사이의 값이 나오므로)
            result = (300%50);
        }
        System.out.println(result);
    }
}
