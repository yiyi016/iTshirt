--javalink / javalink
--테이블 
drop table book;

create table book(
id varchar2(10) primary key,
name varchar2(10),
price number(30) 
);

insert into book values('aaa', 'hong', 1000);
insert into book values('bbb', 'hong2', 2000);
insert into book values('ccc', 'hong3', 3000);

select * from book;