package week08.day33.course.sampleno2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 컴포넌트 어노테이션 정의. 괄호(이름)이 없으므로 Engineer는 engineer라는 이름으로 객체가 생성됨 (첫글자를 소문자로 바꾼것)
public class Engineer {
	@Autowired
	// emp에만 적용됨 (dept에는 적용되지 않음) dept에도 적용하려면 따로 붙여줘야함. 멤버변수마다 적용되므로.

	@Qualifier("emp1")  // 얘는 아래처럼 Resourse쓰는것과 동일
//	@Resource(name="emp1")
	private Emp emp;
	// emp변수에는 Emp 객체를 주입. 그 중 emp1이라는 ㅣㅇ름으로 만든 객체를 주입해주라는 것


	private String dept;
	
	public Engineer() {
		super();
		System.out.println("Engineer 객체 생성 - no args");
	}


	@Autowired // 일반 메서드에도 정의할 수 있음.
	public void ddd(String dept) {   // 스트링 타입의 객체가 bean으로 등록된것이 있는지 확인 -> 있으면 얘를 주입받음. (아까 developer라고 설정해둠.-> dOfmf wndlq)
		this.dept = dept;
		System.out.println("Engineer 객체의 ddd() 메서드에 설정된 메서드 오토와이어를 이용한 dept 변수 설정-"+dept);
	}

	@Override
	public String toString() {
		return emp.toString()+"\n"+ "and works at the "+dept+" department.";
	}
}








