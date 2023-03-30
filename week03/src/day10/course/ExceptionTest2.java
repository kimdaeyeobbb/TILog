package day10.course;
public class ExceptionTest2 {
	public static void main(String[] args){
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			// 인자로  넘겨준것이 아무것도 없으므로
			// 여기서 ArrayIndexOutOfBoundsException 발생

			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 2 개 전달하세요!!");
		} catch (ArithmeticException e) {
		 System.out.println(e.getMessage());
			System.out.println("두번째 프로그램 아규먼트는 0이 아닌 값을 전달하세요!!");
			return;   // 프로그램이 끝남. JVM에게로 돌아감. 어떤상황이든 finally를 수행하고 리턴함.
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("프로그램 아규먼트로 숫자를 전달하세요!!");
		}  catch(Exception e){
			System.out.println("예외발생");
		} finally {
			System.out.println("항상 수행!!");
		}
		System.out.println("수행종료");  // return문 떄문에 얘는 실행되지 않을수도 있다
	}
}