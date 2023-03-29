package day2.hw;

public class ForLab2 {
    public static void main(String[] args) {
        for (int n=9; n>=4; n--){
            String oddEven = (n%2 == 0) ? "짝수" : "홀수";
            System.out.println(n+ " : " +oddEven);
        }
    }
}
