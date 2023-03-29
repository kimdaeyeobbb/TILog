package day5.hw;

public class MethodLab8 {
    public static void main(String[] args) {
        System.out.println("호출 1 : "+addEven(10,2,5,13,7));
        System.out.println("호출 2 : "+addEven(11,22,33,44,55,66));
        System.out.println("호출 3 : "+addEven());
        System.out.println("호출 4 : "+addEven(100,101,103));
    }

    public static int addEven(int... numArr){
        int result = 0;
        if (numArr.length == 0) {
            result = -1;
        } else {
            for (int i=0; i<numArr.length; i++){
                if(numArr[i]%2 == 0){
                    result += numArr[i];
                }
            }
        }
        return result;
    }
}
