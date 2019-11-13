drop table department;

alter table department
alter column monthly_budget type numeric(7,2);

insert into department (dept_name, monthly_budget) values ('HR',6500);

select *
from department
where dept_id = 1;

create table employee (
	empl_id serial constraint empl_pk primary key,
	empl_name varchar(50),
	monthly_salary numeric(7,2),
	empl_position varchar(25),
	manager_id integer,
	dept_id integer references department(dept_id)
);

insert into employee (empl_name, monthly_salary, empl_position, dept_id) values ('Lola Jenkins', 4000, 'HR_REP', 1);

-- we can't do either of these commands as they violate referential integrity
drop table department;

delete from 
department
where dept_id=1;

insert into department (dept_name, monthly_budget) values ('Marketing', 9200);
insert into department (dept_name, monthly_budget) values ('IT', 8000);
insert into department (dept_name, monthly_budget) values ('Sales', 9200);

update department
set monthly_budget=8800
where dept_id=4;

insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (3, 'Aleta Gasgarth', 4052, 'HR Director', null, 1);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (4, 'Ulrike Hector', 3823, 'HR Assist Dir', 3, 1);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (5, 'Charis Fike', 3930, 'MKT Dir', null, 2);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (6, 'Jemie Duffin', 3484, 'MKT Rep', 5, 2);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (7, 'Mildrid Legerwood',  3863, 'IT Manager', null, 3);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (8, 'Huey Fasson',  2869, 'IT Assist Manager', 7, 3);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (9, 'Baxie Dalgleish',  3523, 'IT Rep', 8, 3);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (10, 'Giacomo Ren', 2863, 'IT Rep', 8, 3);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (11, 'Billi Bisset',  2430, 'Sales Director', null, 4);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (12, 'Kirby Burgoine',  2687, 'Sales Rep', 11, 4);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (13, 'Huey Cathee', 3434, 'HR Rep', 4, 1);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (14, 'Lenora Craister', 4224, 'HR Rep', 4, 1);


select * from employee;

select empl_name, empl_position from employee;

select empl_name, empl_position
from employee 
where dept_id=4 or dept_id=3;

select empl_name, empl_position
from employee 
where dept_id in (3,4);

select *
from employee 
order by monthly_salary desc;

-- aliasing a column
select dept_id as id, dept_name as department 
from department;

