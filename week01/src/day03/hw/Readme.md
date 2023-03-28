
# 과제

성명, 이메일주소, 연봉, 입사후30주년일자, 근속년수(소수2자리까지), 입사일자를 출력하시오.
- 성명은 붙여서 출력합니다.
- 이메일주소는 @kosa.com을 붙입니다.
- 연봉은 커미션을 반영하고, 급여의 12배, 환율은 1240으로 하며, 천단위로 버림합니다.
- 입사후 30주년기념일자는 '일-월-년'으로 출력합니다.
- 80번부서로 한정합니다.
- 근속년수로 많은 순서로 정렬합니다.

<br>

- optional 
  - 30주년기념식일자도 출력합니다. 
  - 기념식일자는 30주년이 지난 다음주 월요일입니다.


# 제출본

```sql
select
	CONCAT(first_name, last_name) 성명,
	CONCAT(email, '@kosa.com') 이메일,
	CONCAT(FORMAT(TRUNCATE(salary*12*1240, -4),0), '원') 연봉,
	date_format(DATE_ADD(hire_date, INTERVAL 30 YEAR),'%d-%m-%Y') 입사후30주년일자,
	date_format(sysdate(),'%Y')-date_format(hire_date,'%Y') 근속년수
from 
	employees
where 
	department_id = 80
order by
	근속년수 desc
```



<br>




# 과제2


## 1. 부서번호, 부서명, 부서장사번, 부서장성명, 부서장입사일자를 출력하시오. (단, 부서장이 없으면 부서장없음으로 출력)



## 2. 자신의 관리자보다 먼저 입사한 직원의 이름 사번, 성명, 입사일자, 관리자입사일자를 출력하시오


## 3. Seattle에 근무하는 직원의 사번, 성명, 입사일자, 부서번호, 부서명을 출력 (단.서브쿼리로 합니다.)


## 유의사항

부서장

→ 부서장이 없으면 부서장 사번도 없으므로 ‘없음’이라고 기재할 것
(부서장 성명도 부서장이 없으면 ‘없음’으로 기재할 것)

# 제출본

## 1번

```sql
select 
    d.department_id, 
    d.department_name, 
    ifnull(e.employee_id, '부서장없음'), 
    e.last_name, 
    e.first_name, e.hire_date
from employees e right join departments d on e.employee_id = d.manager_id;
```

## 2번

```sql
select 
    e.employee_id, 
    e.last_name, 
    e.first_name, 
    e.hire_date, 
    m.last_name,
    m.hire_date
from employees e join employees m on e.manager_id = m.employee_id
where e.hire_date < m.hire_date;
```

## 3번

```sql
select 
    e.employee_id, 
    e.last_name, 
    e.hire_date, 
    e.department_id,
    (select department_name 
     from departments 
     where department_id = e.department_id) dept_name
from employees e
where department_id in (select department_id
						from departments
                        where location_id = (select location_id
										      from locations
                                              where city='Seattle'));
```


<br>

- 참고자료

[MySQL 날짜 문제 풀기](https://i-am-lsw.tistory.com/5)

[Mysql 특정 요일의 날짜 값 구하는 쿼리 작성법 (예: 저번주 토요일, 이번주 월요일)](https://bscnote.tistory.com/122)
