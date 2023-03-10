package day0310.hw02;

public class MethodLab7 {
    public static void main(String[] args) {
        int[]result = {};

        for (int i=2; i<=4; i++){
            result = powerArray(i);
            printArray(result);
        }
    }

    public static int[] powerArray(int num){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        for (int i=0; i<arr.length; i++){
            arr[i] = arr[i]*num;
        }
        return arr;
    }

    public static void printArray(int[] arr){
        String result = "";
        for (int i=0; i<arr.length-1; i++){
            result += arr[i] + ",";
        }
        result += arr[arr.length-1];
        System.out.println(result);
    }
}
