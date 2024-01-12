drop table board;
show databases;

use my_cat;

create table board (
	b_no int primary key auto_increment, 	#글번호
	b_title char(100) not null,				#글제목
	b_datetime datetime not null,			#작성시간
    b_hit int default 0 not null,			#조회수    
    b_text text								#글내용
);

create table idpw (
    b_id char(20) not null,					#작성자 ID
    b_pw char(20) not null					#작성자 PW
);

desc board;

select * from board;
select * from idpw;
alter table idpw drop column b_user;
alter table board add b_user int not null;
Insert into board(textnumber, b_title, b_datetime, b_hit, b_text) value (0 , '123123', now(), 0,  + '123123');
alter table idpw add b_user int primary key auto_increment;	#유저 고유 번호(절대 변경될일 없음)
SELECT board.b_user, board.b_title, board.b_text
FROM board
LEFT JOIN idpw ON board.b_user = idpw.b_user;

select * from board order by b_no desc;