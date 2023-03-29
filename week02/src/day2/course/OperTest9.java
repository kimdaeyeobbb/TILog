package day2.course;

public class OperTest9 {
    public static void main(String[] args) {
        int num = 100;
        num++;
        System.out.println(num);  // 101
        ++num;
        System.out.println(num);  // 102
        --num;
        System.out.println(num); // 101
        num--;
        System.out.println(num);  // 100
        System.out.println("---------------------");
        int result;
        result = num;  // 100
        System.out.println(result + " : " + num); // 100, 100
        result = num + 1;  // num자체에는 변화 없음 (num을 r-value로만. 즉, 값으로만 사용)
        System.out.println(result + " : " + num);  // 101, 100
        result = ++num;  // 여기서는 num을 값(r-value)이자 방(l-value) 모두로 사용함
        System.out.println(result + " : " + num);  // 101, 101
        result = num++;
        System.out.println(result + " : " + num); //
    }
}