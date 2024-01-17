drop table squad;		# 테이블 삭제
use my_cat;		# my_cat이라는 데이터베이스 사용
show tables;	# my_cat 데이터베이스 안에 있는 테이블들 출력
select * from squad;	# squad 테이블 출력
select * from squad where t_position = '공격수';	# t_position 칼람의 '공격수'만 출력
delete from squad where t_no = 7;	# t_no 칼람 중 7번 해당하는 데이터 삭제
update squad set t_name = '로드리고밴탄쿠르' where t_no=30;	# t_no 30번에 해당하는 데이터의 t_name의 데이터를 수정
select * from squad where t_no >= 7;	# t_no가 7 이상인 데이터들만 출력
select * from squad where t_no >= 6 && t_name like '%제%';	# t_no가 6이상이면서 t_name에 '제'가 포함된 데이터들 출력
alter table squad add weekly_pay int;	# squad 테이블에 weekly_pay(int형) 칼람 추가
select * from squad order by t_no; # t_no가 오름차순이 되게끔 출력(default : asc)
select * from squad order by t_no asc;	#desc : 내림차순
select * from squad order by t_height desc, t_weight asc;
update squad set weekly_pay = 1000 where t_no = 22;	# t_no가 22인 데이터의 weekly_pay 값을 1000으로 업데이트
update squad set weekly_pay = 1500 where t_no = 63;
update squad set weekly_pay = 800 where t_no = 4;
update squad set weekly_pay = 950 where t_no = 38;
select * from squad order by weekly_pay desc;	# weekly_pay가 내림차순이 되게끔 출력
select t_no, t_name from squad;		# squad의 테이블에서 t_no, t_name만 출력
update squad set weekly_pay = 1500;	# 모든 선수의 주급 1500으로 설정
select weekly_pay from squad;	# 선수들의 주급만 출력
select t_no, t_name, weekly_pay as "주급" from squad;	# 선수단 정보 중 등번호, 이름, 주급 칼럼명은 한글로 표시
select t_no, t_name, weekly_pay/7 as "일급" from squad;	# 선수단 정보 중 등번호, 이름, 일급 표시(일급은 주급을 7로 나누면 됨)
select t_no, t_name, round(weekly_pay/7) as "일급" from squad;	# 입급의 소수점을 반올림 처리(round())
select t_no, t_name, floor(weekly_pay/7) as "일급" from squad;	# 입급의 소수점을 버림 처리(floor())
alter table squad add year_pay int;		# 연봉 칼럼 추가
update squad set year_pay = 18000;
update squad set year_pay = 12000 where t_no = 22;
update squad set year_pay = 9600 where t_no = 4;
update squad set year_pay = 11400 where t_no = 38;
select t_no, t_name from squad where weekly_pay >= 1000 || year_pay >= 10000;	# 선수단 정보 중 등번호,이름을 출력 - 조건은 주급이 얼마 이상이고 연봉이 얼마 이상인 선수만 출력
select t_no as "등번호", t_name as "이름" from squad where weekly_pay >= 1000;
alter table squad add injury char(1);	# 부상 칼럼 추가
update squad set injury='n';	# 부상 여부 입력
update squad set injury='y' where t_no = 22;	# 부상 여부 입력
update squad set injury='y' where t_no = 30;
update squad set injury='y' where t_no = 65;
update squad set injury='y' where t_no = 15;
select * from squad where injury is null;	# injury = null;(이거는 안됨)
select * from squad where injury='y';	# 부상이 'y'인 선수들만 출력
select * from squad where t_name like '%로%';
select * from squad where t_name like '%르%';
select * from squad where t_name like '%로%' union select * from squad where t_name like '%르%';
# 위 둘을 합쳐서 출력(union all select 중복 처리 안하고 출력)

select now() from dual;
select curdate() from dual;
select curtime() from dual;
select date_format(now(), '%Y-%m-%d %H:%i:%s') from dual;
select t_no, t_name, nvl(injury, '출전가능') 부상여부 from squad;

select


create table squad(
	t_id int primary key auto_increment,
	t_no int not null,
    t_name char(50) not null,
    t_birth date,
    t_height int,
    t_weight int,
    t_position char(50) not null
);

#공격수
insert into squad values(0, 22, '브레넌 존슨', '2001-05-23', 179, 73, '공격수');
insert into squad values(0,7,'손흥민','1992-07-08',183,78, '공격수');
insert into squad values(0,63,'제이미 돈리','2005-01-03',180,80, '공격수');
insert into squad values(0,36,'알레호 벨리스','2003-09-19',187,77, '공격수');
insert into squad values(0,9,'히살리송','1997-05-10',179,71, '공격수');
insert into squad values(0,14,'이반페리시치','1989-02-02',186,77, '공격수');

#미드필더
insert into squad values(0,21,'데얀클루셰프스키','2000-04-25',186,75, '미드필더');
insert into squad values(0,19,'라이언세세뇽','2000-05-18',178,70, '미드필더');
insert into squad values(0,30,'로드리고벤탄쿠르','1997-06-26',187,77, '미드필더');
insert into squad values(0,27,'마노르 솔로몬','1999-07-24',167,63, '미드필더');
insert into squad values(0,11,'브리안 힐 살바티에라','2001-02-11',175,60, '미드필더');
insert into squad values(0,58,'야고 산티아고','2003-04-15',180,80, '미드필더');
insert into squad values(0,4,'올리버 스킵','2000-09-16',175,70, '미드필더');
insert into squad values(0,38,'이브스 비수마','1996-08-30',182,72, '미드필더');
insert into squad values(0,10,'제임스 메디슨','1996-11-23',175,73, '미드필더');
insert into squad values(0,18,'지오바니 로셀소','1996-04-09',177,74, '미드필더');
insert into squad values(0,29,'파페 마타르 사르','2002-09-14',184,70, '미드필더');
insert into squad values(0,5,'피에르 호이비에르','1995-08-05',187,84, '미드필더');

#수비수
insert into squad values(0,38,'데스티니 우도지','2002-11-28',186,80, '수비수');
insert into squad values(0,37,'미키 판 더 펜','2001-04-19',193,81, '수비수');
insert into squad values(0,33,'벤 데이비스','1993-04-24',181,76, '수비수');
insert into squad values(0,65,'알피 도링턴','2005-04-20',192,86, '수비수');
insert into squad values(0,35,'애슐리 필립스','2005-06-26',192,86, '수비수');
insert into squad values(0,15,'에릭 다이어','1994-01-15',188,90, '수비수');
insert into squad values(0,12,'에메르송 로얄','1999-01-14',181,79, '수비수');
insert into squad values(0,17,'크리스티안 로메로','1998-04-27',185,79, '수비수');
insert into squad values(0,23,'페드로 포로','1999-09-13',173,71, '수비수');

#골키퍼
insert into squad values(0,21,'굴리엘모 비카리오','1996-10-07',188,83, '골키퍼');
insert into squad values(0,40,'브랜든 오스틴','1999-01-08',188,80, '골키퍼');
insert into squad values(0,41,'알피 화이트맨','1998-10-02',189,84, '골키퍼');
insert into squad values(0,1,'위고 요리스','1986-12-26',188,82, '골키퍼');
insert into squad values(0,20,'프레이저 포스터','1988-03-17',201,93, '골키퍼');