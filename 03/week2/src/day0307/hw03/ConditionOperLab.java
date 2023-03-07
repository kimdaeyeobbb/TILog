package day0307.hw03;

public class ConditionOperLab {
    public static void main(String[] args) {
        int randNum = (int)(Math.random()*5+1);
//        System.out.println(randNum);
        if (randNum == 1){
            System.out.println(300+50);
        } else if (randNum == 2){
            System.out.println(300-50);
        } else if (randNum == 3){
            System.out.println(300*50);
        } else if (randNum == 4){
            System.out.println(300/50);
        } else if (randNum == 5){  // else문으로 처리해도 됨 (애초에 1~5사이의 값이 나오므로)
            System.out.println(300%50);
        }
    }
}
