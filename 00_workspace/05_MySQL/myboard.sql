CREATE DATABASE my_board default CHARACTER SET UTF8MB4;

show databases;

use my_board;

show tables;

drop table board_guest;

CREATE TABLE board_guest(
	board_number int primary key auto_increment,	#글번호
	board_title char(20) not null,					#글제목
    board_id char(20) not null,						#작성자id
	board_datetime datetime not null,				#작성시간
    board_hit int default 0 not null,					#조회수    
    board_text text										#글내용
);

insert into board_guest(board_title, board_id, board_datetime, board_text)
values(
'안녕',
'박상오',
now(),
'테스트내용'
);

select * from board_guest;