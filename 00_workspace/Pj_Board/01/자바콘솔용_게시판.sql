show databases;

use my_cat;

create table board1 (
	b_no int primary key auto_increment, 	#글번호
	b_title char(100) not null,				#글제목
    b_id char(20) not null,					#작성자id
	b_datetime datetime not null,			#작성시간
    b_hit int default 0 not null,			#조회수    
    b_text text								#글내용
);
desc board1;
drop table board1;
insert into board1 (b_title,b_id,b_datetime,b_text) 
values (
'헬로'
,
'cat1'
,
now()
,
'글입니다. 글글.....글....'
);

select * from board1;
select * from board1 order by b_no desc;