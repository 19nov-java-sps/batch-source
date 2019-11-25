-- this is a single line comment 

create table department(
	dept_id serial constraint dept_id primary key,
	dept_name varchar(50),
	monthly_budget numeric(6,2)
);