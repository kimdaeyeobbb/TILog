package day2.hw;

public class SwitchLab2 {
    public static void main(String[] args) {
        int randNum = (int) (Math.random() * 5 + 1); // 1~5
//        System.out.println(randNum);
        int result=0;
        switch (randNum) {
            case 1:
                result = (300 + 50);
                break;
            case 2:
                result = (300 - 50);
                break;
            case 3:
                result = (300 * 50);
                break;
            case 4:
                result = (300 / 50);
                break;
            default:  // case 5와 동일
                result = (300 % 50);
                break;
        }
        System.out.println("결과값 : "+result);
    }
}
