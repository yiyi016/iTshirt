
drop table product;

create table product(
num number(4) primary key,
name varchar2(20),
price number(10)
);

--sequence
--시퀸스 
drop Sequence p_seq;
create Sequence p_seq
start with 0 --시작 
increment by 1 -- 증가 
minvalue 0; 

select * from product;

