package day3.hw;

public class WhileLab3 {
    public static void main(String[] args) {
        int count = 0;
        while(true){
            int randNum = (int)(Math.random()*31);
            char numToChar = ((char)(randNum+'@'));
            if (randNum == 0 || (27<= randNum && randNum <=30)){
                System.out.printf("출력횟수는 %d번입니다", count);
                break;
            }

            System.out.printf("%d-%c, %d", randNum,numToChar, (int)(numToChar));
            System.out.format(", 0x%02X\n", (int)numToChar);
            count +=1;
        }
    }
}
