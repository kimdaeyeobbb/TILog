
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
