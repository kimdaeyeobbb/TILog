package day2.course;

public class OperTest12 {

    public static void main(String[] args) {
        int num = 100;

        System.out.println(num > 100 && ++num == 101); // false
        System.out.println(num);

        System.out.println(num > 100 || ++num == 101); // true
        System.out.println(num);

        System.out.println(num > 100 || ++num == 101);  // true
// or 연산자는 앞의식이 true이면 뒤의식을 수행하지 않음
        System.out.println(num);  // 101
    }

}