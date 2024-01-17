drop table board;
show databases;
show tables;
drop table reply;
use my_cat;

create table board (
	textnumber int primary key auto_increment, 	#글번호
	b_title char(100) not null,				#글제목
	b_datetime datetime not null,			#작성시간
    b_hit int default 0 not null,			#조회수    
    b_text text								#글내용
);

create table idpw (
    b_id char(20) not null,					#작성자 ID
    b_pw char(20) not null					#작성자 PW
);

create table reply(
	r_number int primary key auto_increment,
	r_user int,
    r_datetime datetime not null,
    r_replyText char(50),
    r_userid char(20) not null
);

create table adminBoard(
	a_number int primary key auto_increment,
    a_title char(100) not null,
    a_datetime datetime not null,
    a_hit int default 0 not null,			#조회수    
    a_text text
);

desc board;

select * from board;
select * from idpw;
select * from reply;
select * from adminBoard;
alter table board drop column b_user;
alter table board add b_user int;
Insert into board(textnumber, b_title, b_datetime, b_hit, b_text) value (0 , '123123', now(), 0,  + '123123');
alter table idpw add b_user int primary key auto_increment;	#유저 고유 번호(절대 변경될일 없음)
SELECT board.b_user, board.b_title, board.b_text
FROM board
LEFT JOIN idpw ON board.b_user = idpw.b_user;

select * from board order by b_no desc;