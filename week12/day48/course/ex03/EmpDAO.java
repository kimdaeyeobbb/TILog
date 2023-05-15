package jpamvcexam.model.dao;

import jpamvcexam.model.vo.EmpFreqVO;
import jpamvcexam.model.vo.EmpVO;

import javax.persistence.*;
import java.util.List;

public class EmpDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
    EntityManager em = factory.createEntityManager();
    public void close() {
    	em.close();
    	factory.close();
    }
	public Long getAllDataNum() {	
		TypedQuery<Long> q = em.createQuery("select count(t.empno) from EmpVO t", Long.class);
		return q.getSingleResult();
		// 수행결과가 한 행이므로 singleresult를 쓸 수 있음.
		// 추출 결과가 두개이상이거나 없으면 error 발생
		// 추출 결과가 몇개인지 모르면 getresultlist로 받아야 함
	}
	
	public String getEmpNum(Integer numOfEmp) {
		EmpVO e = em.find(EmpVO.class, numOfEmp);
		if (e != null)
			return e.getEname();
		else
			return "없음";
	}

	public List<EmpVO> findByJob(String job) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.job = :job", EmpVO.class);
		q.setParameter("job", job); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> findByPartEname(String partEname) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename like :pe", EmpVO.class);
		q.setParameter("pe", "%"+partEname+"%"); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}
	
	public List<EmpVO> findByGreaterThanSal(int sal) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.sal >= :sal", EmpVO.class);
		q.setParameter("sal", sal); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> findByEnameAndJob1(String ename, String job) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename = :ename and t.job = :job", EmpVO.class);
		// 파리미터를 2개 설정함 (ename, job)
		// 밑에 방법보다 이 방법이 더 권장됨
		q.setParameter("ename", ename);
		q.setParameter("job", job); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public EmpVO findByEnameAndJob2(String ename, String job) {
		// ?1, ?2는 숫자로 설정한 것. 1은 ename, 2는 Job으로 설정하라는 것
		TypedQuery<EmpVO>  q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename = ?1 and t.job = ?2", EmpVO.class);
		q.setParameter(1, ename); 
		q.setParameter(2, job); 
		EmpVO result = q.getSingleResult();
		return result;
	}
	
	public List<EmpFreqVO> findByEmpFreqVO() {
		//vo객체를 생성하게끔해서 처리해야 함.
		// vo 내부에 생성자를 무엇을 받는지를 기재해둠

		TypedQuery<EmpFreqVO>  q = em.createQuery("SELECT new jpamvcexam.model.vo.EmpFreqVO(t.empno, t.ename, t.hiredate, t.sal, t.deptno) FROM EmpVO t", EmpFreqVO.class);
		List<EmpFreqVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> listPart(int start, int num) {
		// 월급많은순서
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t ORDER BY t.sal DESC", EmpVO.class);
		q.setFirstResult(start);    // 조회 시작 위치
		q.setMaxResults(num);       // 조회할 데이터 수
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}
	
	public Object[] getGroupFunc() {
		// 그룹함수는 어떤 타입으로 추출한다는것을 정할 수 없음. 그냥 함수 결과를 받아올 뿐임. 따라서 typedquery가 아닌 query로 받아옴
		Query query = em.createQuery("SELECT sum(t.sal), max(t.sal), min(t.sal) FROM EmpVO t");
		Object[] result = (Object[])query.getSingleResult(); // 하나의 행을 받아오므로 GetsingleResult를 호출 -> 객체 배열로 리턴
		return result;
	}	
	
}
