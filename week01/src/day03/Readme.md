# 데이터베이스란

- 통합 관리되는 데이터들의 구조적인 모임(집합)
<BR> (일반적으로 컴퓨터 시스템을 이용하여 구축한 데이터의 집합을 뜻함)

- 데이터베이스는 데이터를 저장하고 관리하는 역할을 함
- 파일철에 들어있는 것들은 모두 DB라고 볼 수 있음
- 어떤 쿼리를 만들 때에는 ERD(데이터베이스의 구조를 한눈에 알아볼 수 있는 개체-관계 모델)를 주로 참조해야만 함 

- 데이터베이스는 관계형 / 비관계형 데이터베이스로 나뉨

<br>

## 관계형 데이터베이스

- 여러 테이블을 구성하여 서로 관계를 맺은 상태에서 데이터를 관리함
- ex) PostgreSQL(오픈소스 DBMS), ORACLE, MySQL

## 비관계형 데이터베이스

- 테이블이 아닌 다른 유형으로 데이터를 관리함
- ex) MongoDB, Redis, Couchbase



# MySQL

- 오라클이 MySQL을 관리하고 있으나, 상업용 버전을 만든것이 엔터프라이즈임.

- MySQL은 LAMP라 함.
<BR>(L: Linux, A: Apache, M: MySQL, P: Perl/PHP/Python)

- (개인적인 생각이심) 가볍다. 하지만 있을것은 다 있다.
- 오픈소스인 postgreSQL은 조금 더 묵직한 느낌임. postgreSQL은 오픈소스임. 
- 스타트업은 MySQL을 선호함. 조금 더 묵직하게 잘 서비스하고 이러한 회사에서는 postgresql을 쓰는 경향이 있다. 
 
- 웹 애플리케이션은 웹브라우저로 접속하면 되니까 배포할 필요가 없다.



- 워크벤치
  - dbms를 사용하기 위한 클라이언트 도구


- 클라이언트 도구
  - DBMS 클라이언트 도구 중 mysql은 워크벤치라는 클라이언트 도구로 사용함 
  - 클라이언트 도구에는 TOAD, Orange, SQL Gate for oracle, SQL Developer가 있음


<BR>

# 트랜잭션

- 데이터베이스의 상태를 변환시키는 하나의 논리적 기능 수행단위
<br>(한 번에 수행되어야 할 일련의 연산)


- 학사관리시스템에서 수강신청했던 경험이 존재.  내가 원하는 시간대의 과목을 수강하기 위해서 PC방에 가서 광클한 경험이 있을 것이다 
<br> =>  이미 수강신청이 끝났다는 메시지 등장 
<br> =>  얘가 트랜잭션
<br> (먼저 트랜잭션을 일으키고 수강신청을 하려고 한 것!)


- 예약도 마찬가지임. 콘서트든, 장비이든, 영화이든 모두 트랜잭션 쪽임


<br>

# 데이터베이스 관리 시스템 (DBMS. DataBase Management System)

- 데이터베이스를 관리하는 미들웨어 
- DBMS를 통해 데이터베이스의 데이터를 저장/추출/수정할 수 있음


<br>


# SQL 관계형 모델

- 학생관련 테이블이 있다고 가정해보자.

## 튜플

- 테이블의 ROW
- 엑셀시트상 한줄 한줄이 튜플임 (가로줄)
- 엑셀시트로 나타내면 좋음
- 한줄이 하나의 학생에 대한 정보에 해당됨

## 릴레이션 (Relation)

- 튜플의 집합


## 어트리뷰트

- 릴레이션의 특징을 나타내는 단일 데이터 (컬럼)


## 도메인

- (DB상) 특정 어트리뷰트가 가질 수 있는 값의 집합

<BR>

# DB설계

- 시스템을 분석 설계할 떄에 `도메인 분석 설계`는 domain driven development 도메인 주도 개발을 뜻함


<br>

# primary key

- 릴레이션에서 튜플을 구분하기 위해 사용하는 기본 키
- 하나의 어트리뷰트 혹은 어트리뷰트의 집합(복합키)으로 구성될 수 있음
- 중복되지않는 값이므로 동일한 PK를 지닌 레코드가 존재할 수 없음


<br>

# foriegn key

- 다른 릴레이션의 기본키를 참조하는 키
- 다른 릴레이션의 튜플을 저장 및 관리함
- 릴레이션 간의 관계를 나타내기 위해서 사용됨


# MySQL data types


| 타입  | 형태                                       | 특징                                         |
|:----|:-----------------------------------------|:-------------------------------------------|
| 정수  | TINYINT<br>SAMLLINT<BR>INT<BR>BIGINT<BR> | 1 Byte<br> 2 Bytes<br> 4 Bytes<br> 8 Bytes |
|소수|DECIMAL(P,S)<BR>FLOAT<BR>DOUBLE|고정 소수점<BR>부동 소수점<BR> 부동 소수점|
|연속형|AUTO_INCREMENT||
|문자|CHAR<BR>VARCHAR<BR>TEXT<BR>BLOB|고정길이<BR>가변길이<BR>대량의 데이터<BR>이진 데이터|
|날짜|YEAR<BR>DATE<BR>TIME<BR>DATETIME<BR>TIMESTAMP|1 Byte<br>3 Bytes<br> 3 Bytes<br> 8 Bytes<br> 4 Bytes|


db상 데이터타입을 알아야 함

float, double은 부동소수점임

varchar와 달리, char는 고정된 길이를 사용함



# SQL 작성순서

```sql
SELECT ~  -- 열_리스트
FROM ~  -- 테이블 리스트
WHERE ~ -- 조건
GROUP BY ~  -- 열 리스트 (HAVING 조건)
ORDER BY ~  -- 열 리스트 (ASC/DESC)
```

# SQL 실행순서


```sql
select *
from employees
where department_id = 80;
```

from → where → select 순서대로 진행

```sql
# 커미션을 받는 직원을 조회 commission_pct
# commission_pct 컬럼이 null이 아닌 경우로 조회해야하는구나
# is not null이라는 연산자를 써야한다. 

select *
from employees
where commission_pct is not null;  -- 
```


# 연산자 우선순위

기억해야하는 것은 and와 or연산자에도 우선순위가 존재한다는 것이다.

sql 쓸 때에는 그런부분이 신경쓰인다.

예를들어

```sql
# 연산자 우선순위
select *
from employees
where department_id = 70 or department_id = 80 and last_name like 'K%'
```

실제로는 and를 먼저계산하고나서 or를 계산함

or를 먼저 계산하고 싶다면 다음과 같이 괄호를 넣어줄 것

```sql
# 연산자 우선순위
select *
from employees
where (department_id = 70 or department_id = 80) and last_name like 'K%'
```

결과가 달라진 것을 확인할 수 있다.


<BR>

# order by


sql상 실행하는 순서에서 가장 마지막에 있음

```sql
select *
from employees
where (department_id = 70 or department_id = 80) and last_name like 'K%'
order by 1 desc
```

- 숫자 1이 의미하는 바 
  - select 상 등장하는 컬럼 중 첫번째를 의미함

```sql
# 연산자 우선순위
select first_name, salary, hire_date
from employees
where (department_id = 70 or department_id = 80) and last_name like 'K%'
order by 1 desc
```

# MySQL 내장 함수

|함수|특징|
|:---:|:---|
|IFNULL|컬럼이나 표현식이 NULL이면 다른 값으로 대체함|
|ISNULL|컬럼이나 표현식이 NULL인지를 검사함|
|now()<br>sysdate()|현재시각 조회|
|DATE_FORMAT<BR>STR_TO_DATE|날짜 및 시각 포맷|
|DATE_ADD<BR>DATE_SUB|날짜 연산|
|CONCAT|문자열 결합|
|CASE|값의 타입을 변환함|
|JSON_OBJECT|JSON 형태로 리턴함|


<BR>

# 날짜 데이터 타입

- 날짜를 저장하는 Date 타입은 4 Bytes 크기
- 현재 날짜는 `sysdate(), now()`로 참조함
- `Date()`: 년월일 저장
- `Time()`: 시분초 저장
- `Timestamp`: 년월일과 시분초를 저장함



# sql 변환 함수

- 예시

```sql
# 오늘부터 100일 후,
# 오늘부터 1년 후, 입사 후 30주년 일자 계산할 수 있어야 함
# 두 날짜 사이를 연산할 수 있어야 함 (예를 들어, 입사 후 근속 년수)

select now(), date_format(now(), '%m-%d-%Y');
select last_name, hire_date, date_format(hire_date, '%m-%d-%Y') 입사일자
from employees;
```

# NULL


null은 정해지지 않은 값

```sql
# 연봉을 출력 (단, 커미션을 반영하여 )
select salary, commission_pct, salary*(1+ ifnull(commission_pct,0))*12 커미션반영급여 ,last_name
from employees;
```

<br>

# 집계 함수

- 오류있는 코드

```sql
use hr;

select last_name, count(*), count(department_id) from employees;
```

- 올바르게 고친것

```sql
use hr;

select department_id, count(*)
from employees
group by department_id;
```

<br>

# 집계 함수 having 절

- 올바르지 않음

```sql
use hr;

-- select department_id, count(*)
-- from employees
-- group by department_id;

# 부서별 인원수 출력하는데 1명 이하는 제외
# 급여가 5000이상만 반영함

select department_id, count(*)
from employees
where count(*) < 1
group by department_id;
```

- 올바르게 수정한 예시

```sql
# 부서별 인원수 출력하는데 1명 이하는 제외
# 급여가 5000이상만 반영함

select department_id, count(*)
from employees
group by department_id
having count(*) > 1;
```

- count(*)
    - 해당 row의 총 개수를 나타냄


<br>

# case 사용하기

- 컬럼은 없는데 조건이 있는 경우, case를 이용하면 해당 조건에 맞는 칼럼을 생성할 수 있음.

## group by절에서의 case 활용


- 존재하지않는 salary_grade별로 몇명이 되는지를 카운팅 할 때 group by 사용

```sql
select last_name, salary,
    case when salary < 5000 then 'D'
        when salary < 7000 then 'C'
        when salary < 10000 then 'B'
        when salary < 15000 then 'A'
        else 'S'
    end sal_grade
from employees
```

- 그룹화 한 예시

```sql
select 
	case when salary < 5000 then 'D'
	    when salary < 7000 then 'C'
	    when salary < 10000 then 'B'
	    when salary < 15000 then 'A'
	    else 'S'
    end sal_grade,
    count(*) cnt
from employees
group by (
    case when salary < 5000 then 'D'
        when salary < 7000 then 'C'
        when salary < 10000 then 'B'
        when salary < 15000 then 'A'
    else 'S'
    end)
```

## order by 절에서의 case 활용


```sql
select 
	case when salary < 5000 then 'D'
	    when salary < 7000 then 'C'
	    when salary < 10000 then 'B'
	    when salary < 15000 then 'A'
	    else 'S'
    end sal_grade,
    count(*) cnt
from employees
group by (
    case when salary < 5000 then 'D'
        when salary < 7000 then 'C'
        when salary < 10000 then 'B'
        when salary < 15000 then 'A'
		else 'S'
    end), (
        case when salary < 5000 then 5
            when salary < 7000 then 4
            when salary < 10000 then 3
            when salary < 15000 then 2
		else 1
    end)
order by (
    case when salary < 5000 then 5
        when salary < 7000 then 4
        when salary < 10000 then 3
        when salary < 15000 then 2
        else 1
    end)
```

- 정렬할 것들도 (ORDER BY에 있는것들) GROUP BY내부에 포함시켜줘야함 
<br> => 그래서 옆에 나란히 묶어서 써준 것

# Top n Query

- limit & offet을 사용함

```sql
# 입사일자가 가장 빠른 직원 3사람을 출력, 급여가 가장 작은 3명을 출력하라
select * from employees order by hire_date asc limit 3;
```

<br>

# 인덱스

- 인덱스의 칼럼에 대응되는 별도의 객체로 독립적인 저장 공간을 보유함
- Optimizer가 최적의 실행경로를 설정하는데 중요한 Factor가 된다

# JOIN


join조건은 fk가 필요하다.

```sql
# 성, 입사일자, 급여, 부서명 출력 
select e.last_name, e.hire_date, e.salary, d.department_name, d.department_id
from employees e, departments d
where e.department_id = d.department_id;
```

이렇게 조회했을 때 문제가 발생할  수 있다.

outer join을 알고 있으면 문제를 알아차릴 수 있다.

outer join은 join조건을 만족하지 않으면 사라지는 경우가 발생하는데, 이를 방지하는 쿼리이다.

## outer join

---

```sql
# 아직 부서에 배치되지 않아서 부서명을 출력할 수 없는 경우는 사라진다. => outer join이 필요하다.
# 부서에 배치되지 않은 사원이 사라질 수 있음
select count(*)
from employees e;
```

따라서 join을 할 때 표현을 달리해주는게 좋다.

```sql
# 아직 미배치 상태인 직원은 부서명없음이라고 출력하시오.
select last_name, salary, ifnull(d.department_name, '부서명없음')
from employees e 
LEFT JOIN departments d ON e.department_id = d.department_id;
```

# self join

---

입사하면 fk를 사용하지 않는 경우가 많다. (fk는 선택의 영역임)


자신의 관리자의 이름에 대한 정보를 출력하기

```sql
# 관리자 이름도 출력
select *
from employees e
join employees m on e.manager_id = m.employee_id;  -- m: 매니저
```

# 서브 쿼리

---

쿼리 내부에 포함되어 있는 쿼리

```sql
# Steven, King이 근무하는 부서의 부서원 정보를 출력
select department_id from employees 
where last_name = 'King' and first_name='Steven'

select *
from employees
where department_id = 90;
```

이 두개의 쿼리를 하나으 ㅣ쿼리로 만들자

```sql
# Steven, King이 근무하는 부서의 부서원 정보를 출력

select *
from employees
where department_id = (select department_id 
						from employees 
						where last_name = 'King' and first_name='Steven');
```

- 유의사항 - 에러케이스

```sql
#  King이 근무하는 부서의 부서원 정보를 출력
# last_name이 king인 경우만.
select *
from employees
where department_id = (select department_id 
						from employees 
						where last_name = 'King');
```

- 에러 케이스 수정 - 다중 행을 리턴하도록 수정함

```sql
# King이 근무하는 부서의 부서원 정보를 출력
# last_name이 king인 경우만.
select *
from employees
where department_id in (select department_id 
						from employees 
						where last_name = 'King');
```

## 서브쿼리- 다중컬럼 리턴


```sql
# 부서별로 최고 급여를 받는 직원정보 조회
select max(salary) from employees group by department_id;
```

- 에러케이스

```sql
# 부서별로 최고 급여를 받는 직원정보 조회

select last_name,salary,department_id
from employees
where salary in (select max(salary) 
from employees 
group by department_id
)
order by 3;
```

아, 어느사람이 받는 급여가 다른 부서에 가면 최고급여가 아니게 되는 경우가 생기는구나. 하고추측을 할 수 있다.

- 에러케이스 수정

```sql
# 부서별로 최고 급여를 받는 직원정보 조회

select last_name,salary,department_id
from employees
where (salary, department_id) in (select max(salary), department_id 
from employees 
group by department_id
)
order by 3;
```

다중컬럼을 리턴하는 케이스로 수정하였음.

각 부서별 최고급여를 받는 사람에 대한 정보를 잘 추려서 보여줌

여러개의 멀티row를 리턴하니까 ~을 쓴것임

## 서브쿼리 - 상호 연관 서브 쿼리

---

상호 연관 서브 쿼리란,

서브쿼리에서 메인 쿼리를 참조하는 것

서브 쿼리를 예측해보면 ~

```sql
# correlated subquery
# 자기 부서의 평균급여보다 많은 급여를 받는 직원조회
select *
from employees e
where salary > (
	select avg(salary)
    from employees
    where department_id = e.department_id   -- e.departemend_id => 메인 쿼리
);  -- 자기 부서 평균 급여 리턴하도록 할 것
```

```sql
# correlated subquery
# 자기 부서의 평균급여보다 많은 급여를 받는 직원조회
select *
from employees e
where salary > (
	select avg(salary)
    from employees
    where department_id = e.department_id   -- e.departemend_id => 메인 쿼리
);  -- 자기 부서 평균 급여 리턴하도록 할 것
```

## 서브쿼리 - 스칼라 서브 쿼리

---

select절에 쓰이는 서브 쿼리

결과집합이 소량이고, 코드를 간직한 테이블과의 조인이 많음.

실제로 코드를 많이 사용함.

인터넷 쇼핑몰에서 나의 주문정보가 궁금한 경우 (배송중인지 등),

나의 주문정보가 테이블에 저장되어 있는데 주문상태가 배송중인지가 궁금함.

내가 봤을때 주문중으로 뜨지만 테이블에는 배송중이라는 문자열을 저장하면 안됨.

그렇게 저장하면 데이터량도 많아지고, 관리가 힘듦.

따라서 001처럼 코드로 들어있으면 배송중인것임. 이렇게 표시하면 관리하기가 용이함.

```sql
# 자기부서의 평균급여도 출력
select last_name, salary, department_id,
round((select avg(salary) from employees where department_id = e.department_id)) 부서평균급여
from employees e;
```

## from 절에 사용되는 서브쿼리

---

```sql
# from절에 사용된 서브쿼리
# 자기 부서의 평균 급여보다 많은 급여를 받는 사원 조회
# 부서별 평균급여를 from절의 서브쿼리로 처리
select *
from employees e 
join (select department_id, avg(salary) avg_salary
	from employees
    group by department_id
) da on e.department_id = da.department_id
where e.salary > da.avg_salary;

```

괄호안에 테이블과 같은 느낌의 서브쿼리를 넣음

서브쿼리들을 쭉 보면서 서브쿼리란 다양한 형태가 있을 수 있다는것을 알아두면 됨

단, 튜닝이나 최적화관점에서 접근하기는 어렵다.
지금 당장은 힘들지만, 나중에는 꼭 접근해보기를 권고함.

# 과제2

---

## 1. 부서번호, 부서명, 부서장사번, 부서장성명, 부서장입사일자를 출력하시오. (단, 부서장이 없으면 부서장없음으로 출력)

---

ㅁ

## 2. 자신의 관리자보다 먼저 입사한 직원의 이름 사번, 성명, 입사일자, 관리자입사일자를 출력하시오

---

ㅁ

## 3. Seattle에 근무하는 직원의 사번, 성명, 입사일자, 부서번호, 부서명을 출력 (단.서브쿼리로 합니다.)

---

ㅋ

## 유의사항

---

부서장

→ 부서장이 없으면 부서장 사번도 없으므로 ‘없음’이라고 기재할 것
(부서장 성명도 부서장이 없으면 ‘없음’으로 기재할 것)

# 과제1

---

```sql
select
	CONCAT(first_name, last_name) 성명,
    CONCAT(email, '@kosa.com') 이메일,
    CONCAT(FORMAT(TRUNCATE(salary*12*1240, -4),0), '원') 연봉,
    date_format(DATE_ADD(hire_date, INTERVAL 30 YEAR),'%d-%m-%Y') 입사후30주년일자,
    format(DATEDIFF(curdate(),hire_date)/365,2) 근속년수,
    DATE_ADD(hire_date, INTERVAL 30 YEAR),
    DATE_FORMAT(DATE_SUB(DATE_ADD(hire_date, INTERVAL 30 YEAR)), INTERVAL (WEEKDAY()
from 
	employees
where 
	department_id = 80
order by
	근속년수 desc
```

- 참고자료

[MySQL 날짜 문제 풀기](https://i-am-lsw.tistory.com/5)

[Mysql 특정 요일의 날짜 값 구하는 쿼리 작성법 (예: 저번주 토요일, 이번주 월요일)](https://bscnote.tistory.com/122)

# INDEX

---

인덱스가 있으면 쿼리 성능에 도움이 된다.

WHERE절에 있는 컬럼에 INDEX를 사용하면 테이블전체를 뒤질 필요가 없다 (테이블 전체를 다 가지고 오는 것은 I/O를 일으키는 행위가 되고, 속도가 떨어지게 된다.)

데이터는 디스크에 저장되어있다. 디스크에 있는것을 읽어오고 ~
디스크에서 얼마나 읽어오는지가 성능을 결정한다.

디스크에 있는것을 읽어오는 행위는 시간을 걸리게 만듦.

디스크에서 읽어올 때 읽어오는 속도 단위는 밀리세컨드임

읽어오는 량을 줄이는것이 성능을 결정한다.

인덱스를 사용하면 인덱스를 먼저 뒤져서 해당 데이터를 읽어올 수 있으므로 전체를 읽어오는 행위를 피할 수 있다. 하지만 전체를 읽는것이 항상 느린것은 아니다.

인덱스를 사용하면 좋긴하지만, 무조건적으로 사용하는것이 아니라 인덱스를 통해 성능저하를 얼마나 줄이느냐가 관건이다

- 인덱스 읽어오기

```sql
show indexes from employees;
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f81d1c07-b96f-4cb1-84f3-6e3e17cc2029/Untitled.png)

전체에서 인덱스를 가져오는 이유?
→ last_name에 인덱스가 없기 때문임

→ 인덱스를 만들어주자

## 인덱스 생성하기

---

인덱스 생성시 컬럼명, 테이블명, 인덱스 걸고자하는 컬럼등을 포함하여 생성함

```sql
# K로 시작되는 이름 사원조회
select *
from employees
where last_name like 'K%';
create index emp_last_name_idx on employees(last_name);
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/3255edfb-96c5-424f-9411-dca937716725/Untitled.png)

여기서의 cost는 상대적인 값임

~에 따라 cost는 다 달라짐

인덱스를 지워보자

```sql
# K로 시작되는 이름 사원조회
select *
from employees
where last_name like 'K%';
create index emp_last_name_idx on employees(last_name);
drop index emp_last_name_idx on employees;
```

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f5614dba-f046-460d-a57c-33adcc605852/Untitled.png)

- 인덱스가 지워졌나 확인

```sql
# K로 시작되는 이름 사원조회
select *
from employees
where last_name like 'K%';
create index emp_last_name_idx on employees(last_name);
drop index emp_last_name_idx on employees;
show index from employees;
```

## 인덱스를 사용하면 왜 빨라지는가?

인덱스는 객체이다. 인덱스는 테이블처럼 별도로 존재하는 객체이다.
인덱스를 들여다보면 어떤 컬럼에 저장되어 있는 값들이 실제로는 테이블의 위치를 알 수 있다. 특정 값이 존재하는데, 값에 존재하는 데이터들은 ~
거기가서 그것만 읽어올 수 있다. 그러면 전체를 읽어오지 않아도 된다.
디테일하게 보자면 블록단위로 읽어오는 ~

인덱스 객체를 뒤지면 해당되는 데이터(row)가 어디있는지 알 수 있고, 그 부분만 읽어올 수 있기 때문에. 전체를 다 읽지 않아도 되니까 I/O를 일으키는 횟수가 줄어들고.

### PK가 ~되면 자동으로 인덱스가 만들어지는가?

네 자동으로 만들어집니다.

어떤 테이블을 만들어보자

```sql
create table mysample(
	id int,
    name varchar(45));
    
show index from mysample;
```

모든 DBMS는 PK가 생성되면 해당 PK에 대한 INDEX를 자동으로 생성한다. (MYSQL은 된다. 하지만 오라클은 안된다.)

```sql
create table mysample(
	id int,
    name varchar(45),
    primary key(id));
    
show index from mysample;
```

# mysql 인덱스컬럼 변형 비교

- 인덱스는 정렬되어있다.

- 인덱스는 Btree 인덱스 구조이다.

- 인덱스의 내부적인 알고리즘은 Btree이다.(balanced tree. 정렬되어 있다는 뜻)



<br>

# SQL-인덱스-개요

- 인덱스는 테이블의 데이터가 변경되면 인덱스도 바꾸어야 한다.

- 테이블의 데이터가 너무 자주 변경되면 인덱스가 오버헤드를 일으킨다.

- 인덱스에는 별도의 저장공간이 필요하다.

<br>

# 데이터가 변경될 떄마다 외부에서 내부로 인덱스를 다시 정렬하나요?

- 네
  - 굉장히 많은 양의 데이터를 데이터 덤프받는다고함. 백업받는것. 데이터를 다시 부워넣을 떄 인덱스를 지우고 다시 인덱스를 넣고… 인덱스를 지우는 과정이 생긴다. 인덱스라는 것 자체가 지울 떄가있다. 많은 양의 데이터를 집어넣을 때에는 하나하나 집어넣을 떄마다 인덱스를 다 바꾸어야 한다. 어떤경우에는 데이터를 집어넣는데 하루종일 걸리는 경우가 있다. 이러한 경우 관련된 인덱스를 지워버리고, 드랍하고. 인덱스를 새로 생성한다.


<BR>

# NoSQL 

- No SQL
- Not Only SQL
- Non-Relational Operational Database)


- 기존 DB 관리 도구의 데이터 수집/저장/관리/분석의 역량을 넘어서는 대량의 정형/비정형 데이터 세트이며 이러한 데이터로부터 가치를 추출하고 결과를 분석하는 기술


- (초고용량 데이터 처리 등 성능에 특화된 목적을 위해) 비관계형 데이터 저장소에 비구조적인 데이터를 저장하기 위한
분산 저장 시스템


## NoSQL 특징

- 기존의 DB보다 더 융통성 있는 데이터 모델을 사용하고, 데이터의 저장 및 검색을 위한 특화된 매커니즘을 제공함
<BR> => 이를 통해 NoSQL 데이터베이스는 단순 검색 및 추가 작업에 있어서 매우 최적화된 키 값 저장 기법을 사용함
<BR> => 응답속도/처리효율에 있어 매우 뛰어난 성능을 나타냄

- 관계형 모델을 사용하지 않으며 테이블간의 조인 기능이 없음


- 직접 프로그래밍을 하는 등 비SQL 인터페이스를 통한 데이터 엑세스


- 대부분 여러 대의 데이터베이스 서버를 묶어서(클러스터링) 하나의 데이터베이스를 구성


- 관계형 데이터베이스에서 지원하는 Data 처리 완결성(Transaction ACID 지원) 미보장


- 데이터의 스키마와 속성들을 다양하게 수용 및 동작 정의 (Schema-less)


- 데이터베이스의 중단 없는 서비스와 자동 복구 기능 지원


- 확장성/가용성/높은 성능

<BR>

# node.js에서 MongoDB 사용하는 방법


- [node mongodb driver find example - Google Search](https://www.google.com/search?q=node+mongodb+driver+find+example&ei=zFYAZKaNAZeM-AaNiaTYBg&ved=0ahUKEwimo6rj4rz9AhUXBt4KHY0ECWsQ4dUDCA8&uact=5&oq=node+mongodb+driver+find+example&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCAAQogQyBQgAEKIEMgUIABCiBDoKCAAQRxDWBBCwAzoKCCEQoAEQwwQQCjoECCEQCkoECEEYAFDOnwNYnagDYP6pA2gDcAF4AIABiQGIAYMFkgEDMi40mAEAoAEByAEKwAEB&sclient=gws-wiz-serp)

<BR>

# MongoDB 구동 코드


```sql
import { MongoClient } from "mongodb";

// Replace the uri string with your MongoDB deployment's connection string.
const uri = "<connection string uri>";

const client = new MongoClient(uri);

async function run() {
  try {
    const database = client.db("sample_mflix");
    const movies = database.collection("movies");

    // query for movies that have a runtime less than 15 minutes
    const query = { runtime: { $lt: 15 } };

    const options = {
      // sort returned documents in ascending order by title (A->Z)
      sort: { title: 1 },
      // Include only the `title` and `imdb` fields in each returned document
      projection: { _id: 0, title: 1, imdb: 1 },
    };

    const cursor = movies.find(query, options);

    // print a message if no documents were found
    if ((await movies.countDocuments(query)) === 0) {
      console.log("No documents found!");
    }

    // replace console.dir with your callback to access individual elements
    await cursor.forEach(console.dir);
  } finally {
    await client.close();
  }
}
run().catch(console.dir);
```

<BR>

# 정리

```sql
use hr;

-- select department_id, count(*)
-- from employees
-- group by department_id;

# 부서별 인원수 출력하는데 1명 이하는 제외
# 급여가 5000이상만 반영함

-- select department_id, count(*)
-- from employees
-- group by department_id
-- having count(*) > 1;

-- select last_name, salary,
-- 	case when salary < 5000 then 'D'
-- 		when salary < 7000 then 'C'
--         when salary < 10000 then 'B'
--         when salary < 15000 then 'A'
-- 		else 'S'
--     end sal_grade
-- from employees

-- select 
-- 	case when salary < 5000 then 'D'
-- 		when salary < 7000 then 'C'
--         when salary < 10000 then 'B'
--         when salary < 15000 then 'A'
-- 		else 'S'
--     end sal_grade,
--     count(*) cnt
-- from employees
-- group by (case when salary < 5000 then 'D'
-- 		when salary < 7000 then 'C'
--         when salary < 10000 then 'B'
--         when salary < 15000 then 'A'
-- 		else 'S'
--     end)

-- select 
-- 	case when salary < 5000 then 'D'
-- 		when salary < 7000 then 'C'
--         when salary < 10000 then 'B'
--         when salary < 15000 then 'A'
-- 		else 'S'
--     end sal_grade,
--     count(*) cnt
-- from employees
-- group by (case when salary < 5000 then 'D'
-- 		when salary < 7000 then 'C'
--         when salary < 10000 then 'B'
--         when salary < 15000 then 'A'
-- 		else 'S'
--     end), (case when salary < 5000 then 5
-- 		when salary < 7000 then 4
--         when salary < 10000 then 3
--         when salary < 15000 then 2
-- 		else 1
--     end)
-- order by (case when salary < 5000 then 5
-- 		when salary < 7000 then 4
--         when salary < 10000 then 3
--         when salary < 15000 then 2
-- 		else 1
--     end)

# 입사일자가 가장 빠른 직원 3사람을 출력, 급여가 가장 작은 3명을 출력하라
-- select * from employees order by hire_date asc limit 3;

-- # 성, 입사일자, 급여, 부서명 출력 
-- select e.last_name, e.hire_date, e.salary, d.department_name, d.department_id
-- from employees e, departments d
-- where e.department_id = d.department_id;

# 아직 부서에 배치되지 않아서 부서명을 출력할 수 없는 경우는 사라진다. => outer join이 필요하다.
# 부서에 배치되지 않은 사원이 사라질 수 있음
-- select count(*)
-- from employees e;

-- # 아직 미배치 상태인 직원은 부서명없음이라고 출력하시오.
-- select last_name, salary, ifnull(d.department_name, '부서명없음')
-- from employees e 
-- LEFT JOIN departments d ON e.department_id = d.department_id;

-- select
-- 	CONCAT(first_name, last_name) 성명,
--     CONCAT(email, '@kosa.com') 이메일,
--     CONCAT(FORMAT(TRUNCATE(salary*12*1240, -4),0), '원') 연봉,
--     date_format(DATE_ADD(hire_date, INTERVAL 30 YEAR),'%d-%m-%Y') 입사후30주년일자,
--     date_format(sysdate(),'%Y')-date_format(hire_date,'%Y') 근속년수,
--     timestampdiff(DAY, curdate()-hire_date)
-- from 
-- 	employees
-- where 
-- 	department_id = 80
-- order by
-- 	근속년수 desc

# 관리자 이름도 출력
-- select e.last_name, m.last_name
-- from employees e
-- join employees m on e.manager_id = m.employee_id;  -- m: 매니저

-- # Steven, King이 근무하는 부서의 부서원 정보를 출력

-- select *
-- from employees
-- where department_id = (select department_id 
-- 						from employees 
-- 						where last_name = 'King' and first_name='Steven');

-- # King이 근무하는 부서의 부서원 정보를 출력
-- # last_name이 king인 경우만.
-- select *
-- from employees
-- where department_id in (select department_id 
-- 						from employees 
-- 						where last_name = 'King');

-- # 부서별로 최고 급여를 받는 직원정보 조회

-- select last_name,salary,department_id
-- from employees
-- where (salary, department_id) in (select max(salary), department_id 
-- from employees 
-- group by department_id
-- )
-- order by 3;

-- # correlated subquery
-- # 자기 부서의 평균급여보다 많은 급여를 받는 직원조회
-- select *
-- from employees e
-- where salary > (
-- 	select avg(salary)
--     from employees
--     where department_id = e.department_id   -- e.departemend_id => 메인 쿼리
-- );  -- 자기 부서 평균 급여 리턴하도록 할 것

-- # 자기부서의 평균급여도 출력
-- select last_name, salary, department_id,
-- round((select avg(salary) from employees where department_id = e.department_id)) 부서평균급여
-- from employees e;

-- # from절에 사용된 서브쿼리
-- # 자기 부서의 평균 급여보다 많은 급여를 받는 사원 조회
-- # 부서별 평균급여를 from절의 서브쿼리로 처리
-- select *
-- from employees e 
-- join (select department_id, avg(salary) avg_salary
-- 	from employees
--     group by department_id
-- ) da on e.department_id = da.department_id
-- where e.salary > da.avg_salary;

# 인덱스 읽어오기
-- show indexes from employees;

-- # K로 시작되는 이름 사원조회
-- select *
-- from employees
-- where last_name like 'K%';
-- create index emp_last_name_idx on employees(last_name);
-- drop index emp_last_name_idx on employees;
-- show index from employees;

-- create table mysample(
-- 	id int,
--     name varchar(45),
--     primary key(id));
--     
-- show index from mysample;

select
	CONCAT(first_name, last_name) 성명,
    CONCAT(email, '@kosa.com') 이메일,
    CONCAT(FORMAT(TRUNCATE(salary*12*1240, -4),0), '원') 연봉,
    date_format(DATE_ADD(hire_date, INTERVAL 30 YEAR),'%d-%m-%Y') 입사후30주년일자,
    format(DATEDIFF(curdate(),hire_date)/365,2) 근속년수,
    DATE_ADD(hire_date, INTERVAL 30 YEAR),
    WEEKDAY(DATE_ADD(hire_date, INTERVAL 30 YEAR)),
    DATE_FORMAT(DATE_ADD(DATE_ADD(hire_date, INTERVAL 30 YEAR), INTERVAL (8 - (WEEKDAY(DATE_ADD(hire_date, INTERVAL 30 YEAR)))) DAY), '%Y-%m-%d')
from 
	employees
where 
	department_id = 80
order by
	근속년수 desc
```


- [참고자료 1](https://stackoverflow.com/questions/43870329/what-is-the-mysql-alternative-to-oracles-next-day-function)

- [참고자료 2](https://stackoverflow.com/questions/7117639/input-type-submit-vs-button-tag-are-they-interchangeable)
