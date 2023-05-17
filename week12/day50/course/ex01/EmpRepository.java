package springjpa.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.exam.entity.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{
    // 직접 설계한 메서드가 하나도 없음.
}
