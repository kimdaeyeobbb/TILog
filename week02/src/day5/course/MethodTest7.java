package day5.course;
public class MethodTest7 {
	public static void main(String[] args) {
		System.out.println("main() 수행시작");
		System.out.println(args.length);
		System.out.println(args[0]+args[1]+args[2]);  // 전달된 인자가 없으므로 ArrayIndexOutOfBoundsException
		System.out.println("main() 수행종료");
	}	
}
