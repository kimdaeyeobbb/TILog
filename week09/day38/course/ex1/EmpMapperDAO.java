package com.example.springedu.dao;

import com.example.springedu.domain.EmpVO;
import com.example.springedu.domain.PageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface EmpMapperDAO {
    @Select("select count(*) from emp")
    public int getAllDataNum();

    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal  from emp")
    public List<EmpVO> listAll();


    // http://localhost:8088/part?startNum=5&endNum=8 -> error
//    DAO 클래스를 만들 떄에는 endNum-startNum+1을 계산했음.
    // countNum은 넘어오지 않으므로 0이 됨.

    //따라서 endNum대신 CountNum을  url에 입력해야 제대로 나옴
    // http://localhost:8088/part?startNum=5&countNum=4 -> 정상적으로 결과를 얻어냄
    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal from emp order by sal limit #{startNum}, #{countNum}")
    public List<EmpVO> listPart(PageDTO vo);
}