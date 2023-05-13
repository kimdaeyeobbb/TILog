package aop01;


/* aop를 사용하지 않은 예제 */
public class StartMain {
	public static void main(String[] args) {
		CustomerService ob1=new CustomerService();
		// 고객 서비스 객체 (고객과 관련된 처리 기능이 핵심 로직이 됨)

		EmpService ob2=new EmpService();

		ob1.work();
		System.out.println("----------");
		ob2.work();
	}
}
