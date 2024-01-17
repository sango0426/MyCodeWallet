drop table guest_book;

show tables;

use my_cat;

select * from guest_book;

create table guest_book(
	no int primary key auto_increment,
    id char(50) unique not null,
    name char(50) not null,
    age int not null,
    gender char(1) not null,
    call_no char(20) not null,
    hobby char(50)
);

insert into guest_book(id, name, age, gender, call_no, hobby) values('cat1', '고영희', 8, '남', '010-1234-5678', '캣휠타기');