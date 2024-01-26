CREATE DATABASE DaoDto default CHARACTER SET UTF8MB4;
use DaoDto;
show tables;
drop table ps_board_free;
select * from ps_board_free;
select * from member;
CREATE TABLE PS_BOARD_FREE (
		B_NUM INT PRIMARY KEY AUTO_INCREMENT, 			#글번호
		B_TITLE CHAR(100) NOT NULL DEFAULT "",			#글제목
        B_NICKNAME CHAR(20) NOT NULL,					#작성자 닉네임
		B_DATETIME DATETIME NOT NULL DEFAULT now(),		#작성시간
	    B_HIT INT NOT NULL DEFAULT 0,					#조회수    
	    B_TEXT TEXT	NOT NULL,							#글내용, 댓글내용
	    B_REPLY_COUNT INT NOT NULL DEFAULT 0,			#댓글수
	    B_REPLY_ORI INT	NOT NULL DEFAULT -1				#댓글의 원글 번호
	);

CREATE TABLE member (
		membernum INT PRIMARY KEY AUTO_INCREMENT, 			#회원번호
        B_NICKNAME CHAR(20) NOT NULL,						#작성자 닉네임
	    B_ID CHAR(50) NOT NULL,								#작성자ID
        B_PW CHAR(50) NOT NULL								#작성자PW
	);

insert into ps_board_free (b_title,b_nickname,b_text) values ('야옹','cat','aaa');