CREATE TABLE member2 ( 
id VARCHAR2(12), 
passwd VARCHAR2(12), 
name VARCHAR2(12), 
age NUMBER, 
addr VARCHAR2(50), 
email VARCHAR2(30) 
) 

create or replace procedure java_Storedprocedure(
	vmem member2%rowtype;
	
	vid member2.id
	
	is
	begin
		vmem.id := 'Alpha';
		
		insert into member2(id,passwd,name,age,addr,email)
		values (vid,vpasswd,vname,vage,vaddr,vemail);
		
		
	
	end; 

)