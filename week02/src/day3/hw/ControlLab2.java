package day3.hw;

public class ControlLab2 {
    public static void main(String[] args) {
        int num = 0;
        while(num <10){
            num +=1;
            if(num%3 ==0 || num%4==0){
                continue;
            } else {
                System.out.println(num);
            }
        }
    }
}
