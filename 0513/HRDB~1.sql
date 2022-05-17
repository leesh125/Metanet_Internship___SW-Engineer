select dname as 부서명,deptno as "부서 번호" ,loc as 위치 from dept;

select dname, 'it''s deptno:' as "부서 번호는" , deptno as "DNAME AND DEPTNO" from dept;
select dname, Q'[it's deptno:]' as "부서 번호는" , deptno as "DNAME AND DEPTNO" from dept;

-- 데이터 중복 제거 : disticnt
select distinct deptno from emp;
-- distinct는 반드시 select 뒤에 와야함
select distinct job, ename from emp;

-- 결합 연산자 ||
select ename || job from emp;
select first_name || ' ' || last_name as "Name" from employees;

-- Q: Student 테이블에서 모든 학생의 이름과  ID와 체중을 출력하세요
select name || '의 ID : ' || ID || ', WEIGHT is ' || weight as "Id and Weight" from student;

select ENAME || '(' || JOB || ') , ' || ENAME || '''' || JOB || '''' as "NAME AND JOB" 
  from emp;

select ENAME || '''s sal is $' || SAL as "Name and Sal"
  from emp;

-- where 절  
select empno, ename
  from emp
 where empno = 7900;
 
select empno, sal
  from emp
 where sal < 1000;
 
select *
  from emp
 where ename='SMITH';
 
select *
  from emp
 where hiredate = '1980-12-17';
 
-- SQL에서 기본 산술연산자 사용
select ename, sal, sal+100, sal*1.1
  from emp
 where deptno=10;
 
-- between and, >= and <=
select empno, ename, sal
  from emp
 where sal between 2000 and 3000;
 
select empno, ename, sal
  from emp
 where sal >= 2000 and sal <= 3000;
 
select empno, ename, hiredate
  from emp
 where hiredate between '1981-01-01' and '1981-12-31';
 
select empno, ename, hiredate
  from emp
 where hiredate >= '1981-01-01' and hiredate <= '1981-12-31';
 ---------------------------------------
 -- in 연산자
select empno, ename,deptno
  from emp
 where deptno in(10,20);
 
select empno, ename,deptno
  from emp
 where deptno = 10 or deptno = 20;
-----------------------------------------
--like 연산자
select *
  from emp
 where ename like 'S%';
 
select empno,ename,hiredate
  from emp
 where hiredate like '___12%';
 
select empno,ename,hiredate
  from emp
 where hiredate like '81%';
----------------------------------------- 
-- is null/ is not null
select *
  from emp
 where comm is null;
 
select *
  from emp
 where comm is not null; 

select empno, ename, sal, comm, sal+nvl(comm,0)
  from emp;
-----------------------------------------
-- and / or 연산자
select empno, ename, sal, comm
  from emp
 where sal > 1000 and (comm < 1000 or comm is null);
------------------------------------------
-- & 연산자(값을 입력받기)
select empno, ename, sal
  from emp
 where empno = &empno;

select empno, ename, sal
  from emp
 where sal <= &sal;
------------------------------------------
-- order by
select *
  from emp
 order by empno;
 
select empno, ename, deptno
  from emp
 order by deptno asc, empno desc;
----------------------------------------
--집합연산자(UNION) : 중복 데이터 허용 X, UNION ALL : 중복 데이터 허용
select studno, name,deptno1, 1
  from student
 where deptno1 = 101
union
select profno, name,deptno, 2
  from professor
 where deptno = 101;

select studno, name
  from student
 where deptno1 = 101
union
select studno, name
  from student
 where deptno2 = 201;
-----------------------------
--집합연산자(intersect)
select studno, name
  from student
 where deptno1 = 101
intersect
select studno, name
  from student
 where deptno2 = 201;
-----------------------------
--집합연산자(minus)
select studno, name
  from student
 where deptno1 = 101
minus
select studno, name
  from student
 where deptno2 = 201;
-------------------------
--단일행 함수(substr)
-- Student 테이블에서 jumin 컬럼을 사용해서 1 전공이 101번인 학생들의 이름과
-- 태어난 월일, 생일 하루 전 날짜를 출력하세요
select name as "이름", substr(jumin,3,2) as "태어난 월", substr(jumin,5,2) as "태어난 일"
  from student
 where deptno1 = 101;
------------------------
--단일행 함수(instr) : 해당 문자의 인덱스 가져오기
select name, tel, substr(tel,0,instr(tel,')')-1)
  from student
 where deptno1 = 201;

select name, tel, substr(tel,instr(tel,')')+1,instr(tel,'-')-instr(tel,')')-1)
  from student
 where deptno1 = 201;
-------------------------
-- LPAD()
-- LPAD(문자열, 자릿수, 채울문자)
-- student 테이블에서 1 전공이 201 번인 학과 학생들의 id를 총 10자리로
-- 출력하되 왼쪽 빈 자리는 '*' 기호로 채우세요
select name,id,lpad(id,10,'*')
  from student
 where deptno1 = 201;

select lpad(ename,10,'123456789') as LPAD
  from emp
 where deptno = 10;
-------------------------
-- RPAD()
-- RPAD(문자열, 자릿수, 채울문자)
select rpad(ename,9, substr('123456789',lengthb(ename)+1)) as RPAD
  from emp
 where deptno = 10;
-------------------------
--replace
select name, replace(jumin, substr(jumin,7), '*******') as jumin
  from student;
-- student 테이블에서 이름의 가운데 글자만 *로 변경. ex) 서*수
select replace(name, substr(name,2,1), '*')
  from student;

--ex1
select name, tel, replace(tel,substr(tel,instr(tel,'-')+1),'****') as replace
  from student
 where deptno1 = 101;
 
--ex2
select name, tel, rpad(substr(tel,0,instr(tel,'-')),lengthb(tel),'*')
  from student
 where deptno1 = 101;
--------------------------
-- sysdate, months_between
select sysdate
  from dual;
  
select birthday, round(months_between(sysdate, birthday),0) as "개월수"
  from student;

select round(months_between(sysdate,'98/01/25'), 0) as "개월수"
  from dual;
----------------------------
-- next_day(날짜, '요일') :  입력된 날짜로부터 가장 가까운 해당 요일의 날짜
select next_day(sysdate, '수') from dual;
-- last_day(날짜): 해당 날짜의 월 중 마지막 날
select last_day(sysdate) from dual;

select round(sysdate) from dual;

select trunc(sysdate) from dual;

select to_date(to_char(sysdate, 'YYYYMMDD')) - to_date(to_char(s.birthday, 'YYYYMMDD'))
  from student s, dual d;
-----------------------------
--형변환함수(to_char)
-- to_char('날짜','포맷')
select studno, name, birthday
  from student
 where to_char(birthday,'MM') = '01';
 
select studno, name, birthday
  from student
 where to_char(birthday,'MM') in('01','02','03')
    and to_char(birthday,'YY') in('75','76');

select studno, name, birthday
  from student
 where to_char(birthday,'MMDD') = to_char(to_date('22/06/15'), 'MMDD');
 
select sysdate, to_char(sysdate, 'DD') as "DD",  
                   to_char(sysdate,'DAY') as "DAY", 
                   to_char(sysdate,'DDTH') as "DDTH"
  from dual;
  
select sysdate, to_char(sysdate,'RRRR-MM-DD HH:MM:SS')
  from dual;
-----------------------------
--형변환함수(to_char) : 숫자 -> 문자
select sal, to_char(sal, '$999,999.99')
  from emp;

select empno, ename, sal, comm, to_char((sal*12) + comm, 'L999,999') as "SALARY"
  from emp
 where ename = 'ALLEN';
 
select empno, ename, to_char(hiredate,'YYYY-MM-DD') as HIREDATE,
         to_char(sal*12+comm, '$99,999') as SAL, 
         to_char((sal*12+comm)*1.15, '$99,999') as "15% UP"
  from emp
 where comm is not null;
-----------------------------
--to_number('숫자처럼 생긴 문자')
select to_number('10') from dual;
select ascii('A') from dual;
select 10 + '20' from dual;
select 10 + to_number('20') from dual;
-----------------------------
--to_date('문자')
select to_date('2022/05/17') from dual;
select MONTHS_BETWEEN(SYSDATE,to_char('98/01/25')) from dual;
-----------------------------
--일반함수  NVL0 - null 값을 다른 값으로 치환
select empno, ename, to_char(hiredate,'YYYY-MM-DD') as HIREDATE,
         to_char(sal*12+nvl(comm,0), '$99,999') as SAL, 
         nvl(to_char((sal*12+nvl(comm,0))*1.15, '$99,999'),0) as "15% UP"
  from emp;

------------------------------
--emp2 테이블에서 사원번호, 이름, 직급을 출력하되 직급이 없으면 '사원'으로 출력
select empno as "사원번호", 
        name as "이름", 
        nvl(position,'사원') as "직급"
  from emp2;
-------------------------------
--nvl2(컬럼, 널이 아닐 때 치환값, 널 일 때 치환값)
select empno,ename,sal,comm,nvl2(comm,sal+comm,sal + 0)
  from emp;
-------------------------------
select empno, ename, comm, nvl2(comm, 'Exist', 'NULL') as NVL2
  from emp
 where deptno = 30;
-------------------------------
--decode(A,B,'1',null) : A가 B일 경우 '1'을 출력(null은 생략 가능) : IF문과 같음
select deptno, name, decode(deptno,101,'Computer Engineering') as "DNAME"
  from professor;
-------------------------------
--decode(A,B,'1','2') : A가 B일 경우 '1'을 출력, 아닐 경우 '2'를 출력
select deptno, name, decode(deptno,101,'Computer Engineering', 'Etc') as "DNAME"
  from professor;
-------------------------------
--decode(A,B,'1',C,'2','3') : A가 B일 경우 '1'을 출력, A가 C일 경우 '2'을 출력, 아닐 경우 '3'를 출력
select deptno, name, decode(deptno,101,'Computer Engineering', 
                                                102,'Multimedia Engineering',
                                                103,'Software Engineering','Etc') as "DNAME"
  from professor;
-------------------------------
--decode(A,B,decode(C,D,'1')) : A가 B이고 C가 D일 경우 '1' 출력
select deptno, name, decode(deptno,101,decode(name,'조인형','Best!')) ETC
  from professor;
-------------------------------
--decode(A,B,decode(C,D,'1','2')) : A가 B이고 C가 D일 경우 '1' 출력, A가 B이고 C가 D가 아닐 경우 '2' 출력
select deptno, name, decode(deptno,101,decode(name,'조인형','Best!','Good')) ETC
  from professor;
-------------------------------
select name, jumin, decode(substr(jumin,7,1),1,'MAN',2,'WOMAN',3,'MAN',4,'WOMAN') as Gender
  from student
 where deptno1 = 101;
-------------------------------
--case 조건 when 결과1 then 출력1
--             when 결과2 then 출력2
--             else 출력3
--end "컬럼명"
select name, tel, case(substr(tel,1,instr(tel,')')-1)) when '02' then '서울'
                                                             when '031' then '경기도'
                                                             when '032' then '인천'
                                                             when '051' then '부산'
                                                             when '052' then '울산'
                                                             when '055' then '경남'
                                                             else '기타'
                     end "지역번호"                      
  from student
 where deptno1 = 201;

select name, jumin,
        case when substr(jumin,7,1) in ('1','3') then 'MAN'
               when substr(jumin,7,1) in ('2','4') then 'WOMAN'
        end "Gender"
  from student
 where deptno1 = 101;
 
select name, substr(jumin,3,2) as "태어난 달",
        case when substr(jumin,3,2) in ('01','02','03') then '1/4'
               when substr(jumin,3,2) in ('04','05','06') then '2/4'
               when substr(jumin,3,2) in ('07','08','09') then '3/4'
               else '4/4'
        end "분기"
  from student;

select empno, ename, sal,
        case when 1 <= sal and sal <= 1000 then 'Level 1'
               when 1001 <= sal and sal <= 2000 then 'Level 2'
               when 2001 <= sal and sal <= 3000 then 'Level 3'
               when 3001 <= sal and sal <= 4000 then 'Level 4'
               else 'Level 5'
        end "LEVEL"
  from emp;
-------------------------------
--count(* 또는 컬럼) : 컬럼일 경우 널은 카운터에서 제외
select count(*), count(comm)
  from emp;
-------------------------------
--sum(컬럼) : 컬럼 값들의 합
--avg(컬럼) : 컬럼 값들의 평균
select count(comm), sum(comm). avg(comm)
  from emp;
  
select count(*), sum(comm), round(avg(nvl(comm,0)),2) as 평균
  from emp;
  
--min(컬럼): 컬럼에서의 최솟값
--max(컬럼): 컬럼에서의 최댓값
select min(sal), max(sal)
  from emp;

select min(sal), max(hiredate)
  from emp;

--stddev(컬럼) : 컬럼의 표준편차
--variance(컬럼) : 컬럼의 분산
select round(stddev(sal),2) , round(variance(sal),2)
  from emp;
---------------------------------
--group by
select deptno as no,job,round(avg(sal))
  from emp
 group by deptno, job
 order by no;
---------------------------------
--having : 그룹핑한 조건 검색
select deptno, round(avg(sal))
  from emp
 group by deptno
 having avg(sal) > 2000;
---------------------------------
--emp 테이블에서 부서번호가 10보다 큰 부서 중 급여 평균이 2000이 넘는 부서의 부서번호와 평균 구하기
select deptno,avg(sal)
  from emp
  where deptno > 10
  group by deptno,sal
  having sal>2000;
---------------------------------
--join(oracle)
select e.empno, e.ename, e.deptno, d.deptno,d.dname
  from emp e, dept d
 where e.deptno = d.deptno;

--join(ansi)
select e.empno, e.ename, e.deptno, d.dname
  from emp e inner join dept d
    on e.deptno = d.deptno;
---------------------------------
--학생 테이블(student)과 교수 테이블 (professor)을 join 하여 학생의 이름과 지도교수번호, 지도교수 이름을 출력
select s.name as "학생 이름", p.profno as "지도교수번호", p.name as "지도교수 이름"
  from student s, professor p
 where s.profno = p.profno;
 
select s.name as "학생 이름", p.profno as "지도교수번호", p.name as "지도교수 이름"
  from student s, professor p
 where s.profno(+) = p.profno;

select s.name as "학생 이름", p.profno as "지도교수번호", p.name as "지도교수 이름"
  from student s, professor p
 where s.profno = p.profno(+);
 
-- employees 테이블에서 직원의 사원번호, 사원명, 부서번호, 부서명을 출력하세요
select e.employee_id, e.first_name || ' ' || e.last_name as name, d.department_id, d.department_name
  from employees e, departments d
 where e.department_id = d.department_id(+);
------------------------------------
--학생 테이블(student
select s.name, d.dname, p.name
  from student s, department d, professor p
 where s.deptno1 = d.deptno
    and s.profno = p.profno;
    
-- employees 테이블을 참조하여 사원명, 부서명, 부서가 있는 도시, 도시가 속한 나라명
select e.first_name || ' ' || e.last_name as name, 
        d.department_id as "부서명",
        l.city as "도시",
        c.country_name as "나라명"
  from employees e, departments d, locations l, countries c
 where e.department_id = d.department_id
    and d.location_id = l.location_id
    and l.country_id = c.country_id; 

-- gogak 테이블과 gift 테이블을 활용하여 각 고객이 포인트로 받을 수 있는 가장 좋은 선물을 출력
select go.gname, gi.gname
  from gogak go,gift gi
 where go.point between gi.g_start and gi.g_end;
 
-- 학생의 학생명과 시험점수, 학점을 출력하세요. (student, exam_01, hakjum)
select s.studno as "학생명",
        e.total as "시험점수",
        h.grade as "학점"
  from student s, exam_01 e, hakjum h
 where s.studno = e.studno
    and e.total >= h.min_point
    and e.total <= h.max_point;

-- emp 테이블에서 mgr 컬럼은 매니저 사번이다. 각 사원의 사원명과 매니저명을 출력하세요.
select e1.ename, e2.ename
  from emp e1, emp e2
 where e1.mgr = e2.empno(+);
  
-- emp2 테이블과 p_grade 테이블을 조회하여
-- 현재 직급이 있는 사원의 이름과 직급, 현재 연봉, 해당 직급의 연봉의 하한금액과 상한금액을 출력하세요
select e.name, e.position, 
        to_char(e.pay,'999,999,999') as "연봉", 
        to_char(p.s_pay,'999,999,999') as "하한금액", 
        to_char(p.e_pay,'999,999,999') as "상한금액"
  from emp2 e, p_grade p
 where e.position = p.position;

--emp2 테이블과 p_grade 테이블을 조회하여 사원들이 이름과 나이, 현재 직급, 예상 직급을 출력하세요.
-- 예상 직급은 나이로 계산하며 해당 나이가 받아야 하는 직급을 의미합니다.
-- 나이는 오늘(sysdate)을 기준으로 하되 trunc로 소수점 이하는 절삭해서 계산하세요
select e.name,
        to_char(sysdate,'YYYY') - to_char(e.birthday,'YYYY') + 1 as "나이",
        p.position
  from emp2 e, p_grade p
 where to_number(to_char(sysdate,'YYYY') - to_char(e.birthday,'YYYY') + 1) between p.s_age and p.e_age;

select g.gname, g.point
  from gogak g,gift gi
 where gi.gname='노트북'
    and g.point > gi.g_start;

-- professor 테이블에서 교수의 번호, 교수이름, 입사일, 자신보다 입사일 빠른 사람 인원수 출력
-- 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요
select p1.profno,
        p1.name,
        to_char(p1.hiredate,'YYYY/MM/DD'),
        count(p2.hiredate) "COUNT"
  from professor p1, professor p2
 where p1.hiredate>p2.hiredate(+)
 group by p1.profno, p1.name,to_char(p1.hiredate,'YYYY/MM/DD')
 order by 1;
        
select p1.profno,
        p1.name,
        p1.hiredate,
        count(*) as "자신보다 입사일이 빠른 사람 수"
  from professor p1, professor p2
  where p1.hiredate < p2.hiredate
  group by p1.profno,p1.name,p1.hiredate
 order by 4;

-- emp 테이블에서 사원번호, 사원이름, 입사일, 자신보다 먼저 입사한 사람 인원수를 출력하세요
-- 단 자신보다 입사일이 빠른 사람수를 오름차순으로 출력하세요.
select e1.empno,
        e1.ename,
        e1.hiredate,
        count(e2.hiredate) as "COUNT"
  from emp e1, emp e2
 where e1.hiredate > e2.hiredate(+)
 group by e1.empno,e1.ename,e1.hiredate
 order by 4;

select s.name 학생명, p.name 교수명
  from student s, professor p
 where s.profno(+) = p.profno;
--------------------------------------
--sub query
--------------------------------------
--단일행 서브쿼리(=, <>, >, >=, <, <=)
--------------------------------------
select ename,comm
  from emp
 where comm < (select comm 
                        from emp
                       where ename = 'MARTIN');
---------------------------------------
--student 테이블에서 서진수와 전공1이 동일한 학생의 이름을 출력하세요.
select name
from student
where deptno1 = (select deptno1
                        from student
                        where name = '서진수')
and name <> '서진수';

--------------------------------------
--professor 테이블에서 바비 교수보다 나중에 입사한 교수의 이름과 입사일, 학과명을 출력하세요.
select p.name, p.hiredate, d.dname
from professor p, department d
where p.deptno = d.deptno
and  p.hiredate > (select hiredate
                        from professor
                        where name = '바비')
order by 2;

-- student 테이블에서 전공1이 201번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 이름과 몸무게를 출력
select name, weight
from student
where weight > (select avg(weight)
                      from student
                      where deptno1 = 201);
---------------------------------------
--다중행 서브쿼리(in, exists, >any, <any, <all, >all)
---------------------------------------
select empno, name, deptno
from emp2 e
where deptno in (select dcode
                        from dept2
                        where area='포항본사');

--emp2 테이블을 사용하여 전체 직원 중 '과장' 직급의 최소 연봉자보다 연봉이 높은 사람의 이름과 직급, 연봉 출력
--단, 연봉 출력은 '$100,000,000' 형식으로
select name, position, to_char(pay, '$999,999,999')
from emp2
where to_char(pay, '$999,999,999') > (select min(to_char(pay, '$999,999,999'))
                                                from emp2
                                                where position = '과장')
order by 3;
 
select name, position, pay
  from emp2
 where pay >any (select pay from emp2 where position='과장')
 order by 3;

--student 테이블을 조회하여 전체 학생 중에서 체중이 2학년 학생들의 체중에서 가장 적게 나가는
--학생보다 몸무게가 적은 학생의 이름과 학년 몸무게를 출력하세요.
select name,grade,weight
from student
where weight <all(select weight
                        from student
                        where grade = 2);

--emp2,dept2 테이블을 조회하여 각 부서별 평균 연봉을 구하고 그중에서 평균 연봉이 가장 적은 부서의
-- 평균 연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력하세요.
select d.dname,
        e.name,
        e.pay
from emp2 e, dept2 d
where e.deptno = d.dcode
and pay <all(select avg(pay)
                from emp2
                group by deptno);

--student 테이블을 조회하여 각 학년별로 최대 몸무게를 가진 학생들의 학년과 이름과 몸무게 출력
select grade,
        name,
        weight
from student
where (grade,weight) in(select s.grade,
                                max(s.weight)
                                from student s
                                group by s.grade)
order by 1;

--professor, department 테이블을 조회하여 각 학과별로 입사일이 가장 오래된 교수의 교수번호, 이름, 학과명을 출력(입사일 오름차순)
select p.profno,
        p.name,
        p.hiredate,
        d.dname
from professor p, department d
where p.deptno = d.deptno
and (p.deptno, p.hiredate) in  (select p2.deptno,min(p2.hiredate)
                                    from department d2, professor p2
                                    where p2.deptno = d2.deptno
                                    group by p2.deptno)
order by 3;

-- emp2테이블을 조회하여 직급별로 해당 직급에서 최대 연봉을 받는 직원의 이름과 직급,연봉 출력
select name, position, pay
from emp2
where (position,pay) in (select position,max(pay)
                                from emp2
                                group by position)
order by 3;
select *
from department;