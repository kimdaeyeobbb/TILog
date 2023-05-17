package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springjpa.exam.entity.Emp;


public interface EmpRepository2 extends JpaRepository<Emp, Integer>{ // emp를 위한 respository 클래스

	/* 추상 메서드들 */
	// 조상으로부터 받은 메서드가 어느정도의 crud는 가지고 있음.
	// 하지만 특정 엔티티에 특화된 조건을 줘서 데이터를 추룰하려면 이에 맞춰서 메서드를 잘 만들어 놓아야 스프링이 수행코드를 알아서 채워짐
	public List<Emp> findByEname(String name);
	public List<Emp> findByEnameIgnoreCase(String name);
	public List<Emp> findByJob(String job);
	public List<Emp> findByJobOrDeptno(String job, int dno);
	public List<Emp> findByJobAndDeptno(String job, int dno);
	public List<Emp> findDistinctByJob(String job);
	public List<Emp> findByDeptno(int dno);
	public List<Emp> findBySalGreaterThan(int inputsal);
	public List<Emp> findBySalGreaterThanEqual(int inputsal);
	public List<Emp> findBySalLessThan(int inputsal);
	public List<Emp> findBySalLessThanEqual(int inputsal);   // 작거나 같은 데이터를 꺼내겠다는 것
	public List<Emp> findBySalBetween(int minsal, int maxsal);
	public List<Emp> findByCommNull();
	public List<Emp> findByCommNotNull();
	public List<Emp> findByHiredateAfter(java.sql.Date d);  // 날짜데이터는 인자로 전달된 날짜를 기준으로 해서 after, before를 붙일 수 있음
	public List<Emp> findByHiredateBefore(java.sql.Date d);   // 날짜데이터는 인자로 전달된 날짜를 기준으로 해서 after, before를 붙일 수 있음
	public List<Emp> findByEnameStartsWith(String partname);  // 직원명이 ~로 시작하는
	public List<Emp> findByEnameContains(String partname);   // 직원명이 ~를 포함한
	public List<Emp> findByDeptnoOrderBySalDesc(int dno);   // 인자와 관련된 부서 정보와 관련된 데이터 추출
	public List<Emp> findTop3ByDeptnoOrderBySalDesc(int dno);
}
