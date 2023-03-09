package day0309.hw01;

public class ArrayLab1 {
    public static void main(String[] args) {
        int[] any = new int[10];
        for (int i=0; i<any.length; i++){
            any[i] = 10*(i+1);
        }
        System.out.printf("첫 번째 : %d\n", any[0]);
        System.out.printf("마지막 : %d\n", any[9]);
        System.out.printf("합 : %d\n", (any[0]+any[9]));

        for (int e : any){
            System.out.printf(e+" ");
        }
        System.out.println();
        for (int i=any.length-1; i>=0; i--){
            System.out.printf(any[i]+" ");
        }
        System.out.println();

        for (int e: any){
            if(e%20 == 0)
                System.out.printf(e+" ");
        }
    }
}
