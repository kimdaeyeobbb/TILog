package day0309.hw01;

public class ArrayLab3 {
    public static void main(String[] args) {
        char chArr[] = {'J','a','v','a'};
        for (int i=0; i<chArr.length; i++){
            if(Character.isUpperCase(chArr[i])){
                chArr[i] = Character.toLowerCase(chArr[i]);
            } else {
                chArr[i] = Character.toUpperCase(chArr[i]);
            }
        }

        for (char e : chArr){
            System.out.println(e);
        }
    }
}
