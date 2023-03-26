package day0321.course;

public class StandardInput {
    public static void main(String[] args) throws Exception{
        // I/O에 대해 Exception 처리를 안하면 error 발생

        System.out.print("입력 : ");
        char munja = (char) System.in.read();
        // 한 문자만 읽음

        System.out.println(munja);
    }
}
