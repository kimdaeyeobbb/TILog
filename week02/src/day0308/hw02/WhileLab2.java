package day0308.hw02;

public class WhileLab2 {
    public static void main(String[] args) {
        while(true){
            int pairNum1 = (int)(Math.random()*6)+1;
            int pairNum2 = (int)(Math.random()*6)+1;

            System.out.println(pairNum1 + " vs " +  pairNum2);
            if (pairNum1 != pairNum2){
                String result = (pairNum1 > pairNum2) ? "pairNum1이 pairNum2보다 크다" : "pairNum1이 pairNum2보다 작다";
                System.out.println(result);
            } else {
                System.out.println("게임 끝");
                break;
            }
        }

    }
}
