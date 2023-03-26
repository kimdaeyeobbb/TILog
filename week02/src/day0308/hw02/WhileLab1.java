package day0308.hw02;

public class WhileLab1 {
    public static void main(String[] args) {
        int randNum = (int)(Math.random()*6)+5;
        System.out.println("[ for 결과 ]");
        for (int n=1; n<=randNum; n++){
            System.out.printf(" %d -> %d\n", n, n*n);
        }
        System.out.println("[ while 결과 ]");
        int m = 1;
        while(m <= randNum){
            System.out.printf(" %d -> %d\n", m, m*m);
            m += 1;
        }
    }
}
