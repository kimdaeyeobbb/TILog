package day0310.hw02;

public class MethodLab9 {
    public static void main(String[] args) {
        boolean result = true;
        result = isRightTriangle(3,4,5);
        System.out.println(result);

        result = isRightTriangle(1,2,3);
        System.out.println(result);
    }

    public static boolean isRightTriangle(int width, int height, int hypo){
        if(Math.pow(hypo,2)-Math.pow(width,2)-Math.pow(height,2) == 0){
            return true;
        } else {
            return false;
        }
    }

}
