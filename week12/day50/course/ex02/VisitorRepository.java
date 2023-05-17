package springjpa.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.exam.entity.Visitor;


// http://localhost:8088/visitormain.html 로 확인
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{
	// jparepository를 상속하여 내가 원하는 기능을 담고 있는 repository를 만듦
	// repository가 자동으로 빈으로 등록되고, 자동으로 메서드를 만들어줌
	//

	public List<Visitor> findByMemoContains(String keyword);	
	
}
