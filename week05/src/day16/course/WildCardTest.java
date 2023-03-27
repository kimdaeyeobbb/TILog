package day16.course;
import java.util.Date;
class Person {
}
class Worker extends Person {
}
class NewWorker extends Worker {
}
class Student extends Person {
}
class HighStudent extends Student {
}
class MiddleStudent extends Student{
}

class My<T> {
	// My: 제네릭 타입 클래스
	// 객체 생서앟려면 T라는 타입 파라미터에 대한 정보를 주어야 함
	// 컴파일시 T에 전달하는 값으로 바뀜 (객체만 남아있고 제네릭 타입 정보는 컴파일하고나서는 사라짐)

	T obj;
	My(T obj) {
		this.obj = obj;
	}
	public String toString() {
		return obj.getClass().getName()+"객체임";
	}
}
public class WildCardTest {
	static void m1(My<?> p) {
		// ? : 임의의 타입 모두가 올 수 있음

		System.out.println(p);
	}
	static void m2(My<? extends Student> p) {
		// ? extends Student : m2는 My객체 전달시 Student나 Student타입을 상속한 애들에 대한 정보를 주어야 함

		System.out.println(p);
	}
	static void m3(My<? super Worker> p) {
		// ? super Worker : My라는 제네릭 타입 선언시 Worker 혹은 Worker의 조상으로 객체의 타입을 제한

		System.out.println(p);
	}
	public static void main(String[] args) {
		m1(new My<Date>(new Date()));
		m1(new My<String>("abc"));
		m1(new My<Integer>(100));
		m1(new My<Person>(new Person()));
		m1(new My<Worker>(new Worker()));
		m1(new My<Student>(new Student()));
		m1(new My<HighStudent>(new HighStudent()));
		m1(new My<MiddleStudent>(new MiddleStudent()));
		System.out.println("-----------------------");

		/* m2는 Student와 Student의 자손에 대한 객체만 전달 가능 */
		m2(new My<Student>(new Student()));
		m2(new My<HighStudent>(new HighStudent()));
		m2(new My<MiddleStudent>(new MiddleStudent()));
		//m2(new My<Integer>(100));
		//m2(new My<Person>(new Person()));
		//m2(new My<Worker>(new Worker()));
		System.out.println("-----------------------");		

		/* m3는 Worker와 조상객체만 다루는 My객체여야 함 */
		m3(new My<Person>(new Person()));
		m3(new My<Worker>(new Worker()));
		m3(new My<Object>(new Object()));
		//m3(new My<Student>(new Student()));
		//m3(new My<HighStudent>(new HighStudent()));
		//m3(new My<NewWorker>(new NewWorker()));
	}
}
