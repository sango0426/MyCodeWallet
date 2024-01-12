CREATE DATABASE my_cat default CHARACTER SET UTF8MB4;

use my_cat;

show tables;

CREATE TABLE board_guest(
	no int primary key auto_increment,
    con char(255),
    writer char(50)
);

CREATE TABLE board_guest(
	no int,
    con char(255),
    writer char(50)
);

insert into board_guest (con, writer) values('안녕', '안');
insert into board_guest (con, writer) values('하이', '가');
insert into board_guest (con, writer) values('바이', '나');

select * from board_guest;