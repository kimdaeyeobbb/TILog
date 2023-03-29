package day3.hw;

public class ControlLab3 {
    public static void main(String[] args) {
        while(true){
            int randNum = (int) (Math.random() * 120) + 1;
            String str1 = "";
            String str2 = "";
            if(randNum<50){
                str1 = "50미만";
                if (randNum%10 == 3){
                    str2 ="*듀크팀*";
                }
            } else if (randNum>=50 && randNum <=80){
                str1 = "50이상 80이하";
                if (randNum>=70 && randNum <= 79) {
                    str2 = "50 *턱시팀*";
                }
            } else if (randNum >= 81 && randNum <= 100){
                continue;
            } else {
                break;
            }
            System.out.printf("%d : %s\n%d : %s", randNum,str1,randNum,str2);
        }
    }
}