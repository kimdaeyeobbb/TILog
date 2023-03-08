package day0308.hw02;

public class ControlLab1 {
    public static void main(String[] args) {
        int count = 0;
        while(true){
            int randNum = (int)(Math.random()*11)+10;
            System.out.println("난수: "+ randNum);
            if(randNum == 11 || randNum == 17 || randNum == 19){
                break;
            }
            if(randNum%3 == 0 || randNum%5 == 0){
                int sum = 0;
                for (int n=1; n<=randNum; n++){
                    sum += n;
                }
                System.out.println("1부터 " + randNum + "까지의 합: "+sum);
                count += 1;
            }
            else {
                System.out.println("재수행");
            }
        }
        System.out.printf("%d회 반복함", count);
    }
}
