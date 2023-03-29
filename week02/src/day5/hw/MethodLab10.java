package day5.hw;

public class MethodLab10 {
    public static void main(String[] args) {
        int a1[] = new int[] {1,2,3,4,5};
        MethodLab7.printArray(a1);
        powerArray(a1,3);
        MethodLab7.printArray(a1);

        int a2[] = new int[] {10,20,30,40,50,60};
        MethodLab7.printArray(a2);
        powerArray(a2,10);
        MethodLab7.printArray(a2);
    }

    public static void powerArray(int[] arr, int num){
        if(num>=2 && num<=5){
            for (int i=0; i<arr.length; i++){
                arr[i] *= num;
            }
        } else {
            return;
        }
    }
}
