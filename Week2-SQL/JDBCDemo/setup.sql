create table department(
	dept_id serial constraint dept_id primary key,
	dept_name varchar(50),
	monthly_budget numeric(6,2)
);


insert into department (dept_id, dept_name, monthly_budget) values (1, 'HR', 5400);
insert into department (dept_id, dept_name, monthly_budget) values (2, 'Marketing', 9200);
insert into department (dept_id, dept_name, monthly_budget) values (3, 'IT', 8000);
insert into department (dept_id, dept_name, monthly_budget) values (4,'Sales', 9200);

create table employee(
	empl_id serial constraint empl_pk primary key,
	empl_name varchar(50),
	monthly_salary numeric(7,2),
	empl_position varchar(25),
	manager_id integer,
	dept_id integer references department(dept_id)
);



/*
 * Populating Employee Table
 */
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (1,'Steve Jobs', 9000, 'CEO', null, null);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (2,'Lola Jenkins', 4300, 'MKT_DIR', null,3);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (3,'Aleta Gasgarth', 4052, 'HR Director', null, 1);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (4, 'Ulrike Hector', 3823, 'HR Assist Dir', 3, 1);
insert into employee (empl_id, empl_name, monthly_salary, empl_position, manager_id, dept_id) values (5, 'Charis Fike', 3930, 'MKT Rep', 2, 3);