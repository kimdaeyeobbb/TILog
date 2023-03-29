package day4.hw;

public class LottoMachine1 {
    public static void main(String[] args) {

        int lotto[] = new int[6];

        for (int i=0; i<lotto.length; i++){
            int randNum = (int)(Math.random()*45)+1;
            lotto[i] = randNum;
            //System.out.println("랜덤 번호: "+ randNum);

            /* 중복 제거 */
            for (int j=0; j<i; j++) {
                if(lotto[i]==lotto[j]){
                    //System.out.println("중복 번호: "+ randNum);
                    i--;
                }
            }
        }

        /* 결과 출력 */
        String result = "오늘의 로또 번호 - " + lotto[0];

        for (int i=1; i<lotto.length; i++){
            result += ", "+ lotto[i];
        }
        System.out.println(result);
    }
}
