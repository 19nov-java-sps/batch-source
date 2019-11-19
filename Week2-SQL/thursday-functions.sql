
/*
 * Creating User Defined Functions
 * 
 * create or replace function [function name]([params])
 * returns [type]
 * language [lang]
 * as $function$
 * declare
 * -- additional variable declaration
 * begin
 * -- function code
 * end
 * $function$
 * 
 */

create function myFunc()
returns integer
language plpgsql
as $function$
begin 
	return 7;
end;
$function$

select myFunc();

select *
from employee
where empl_id = myFunc();


create function myFunc2()
returns integer
language plpgsql
as $function$
declare
	val integer := 7;
begin 
	return val;
end;
$function$

select myFunc2();

select *
from employee
where empl_id = myFunc2();

drop function myFunc2;

-- we can also parameterize functions
create function add(num1 integer, num2 integer)
returns integer
language plpgsql
as $$
begin
	return num1+num2;
end
$$

select add(2,3);

-- these parameters can be used in queries as well
create function findEmployee(id integer)
returns setof employee
language plpgsql
as $$
begin
	return query select * from employee where empl_id = id;
end
$$

select findEmployee(5);

-- we can also write functions using other DML operations
create function addDept(deptName department.dept_name%type, budget department.monthly_budget%type)
returns setof department
language plpgsql
as $$
declare 
	new_id integer := nextval('department_dept_id_seq'::regclass);
begin
	insert into department values (new_id, deptName, budget);
	return query select * from department where dept_id = new_id;
end
$$

select addDept('new dpt',300);

-- we can fetch values of a query into variables
-- here we manually set an incremented value to our primary key
create function addDept2(deptName department.dept_name%type, budget department.monthly_budget%type)
returns setof department
language plpgsql
as $$
declare 
	max_id integer;
begin
	select max(dept_id) into max_id 
	from department;
	insert into department values ((max_id+1), deptName, budget);
	return query select * from department where dept_id = (max_id+1);
end
$$

select addDept2('new dept 2', 1000);

create or replace function findAvgSal()
returns numeric(7,2)
language plpgsql
as $$
declare
	avgSal numeric(7,2);
begin
	select round(avg(monthly_salary),2) into avgSal
	from employee;
	return avgSal;
end
$$

select findAvgSal();

select *
from employee
where monthly_salary>findAvgSal();

create or replace function applyTax(pre_tax employee.monthly_salary%type)
returns numeric(7,2)
language plpgsql
as $$
begin
	return round((.75)*pre_tax,2);
end
$$

select empl_name as "Employee", monthly_salary as "Pre Tax Income", applyTax(monthly_salary) as "Post Tax Income"
from employee;

create or replace function applyTax(pre_tax employee.monthly_salary%type)
returns numeric(7,2)
language plpgsql
as $$
declare 
	post_tax numeric;
begin
	if pre_tax<3000 then
		post_tax := (.78)*pre_tax;
	elseif pre_tax<4000 then 
		post_tax := (.75)*pre_tax;
	else 
		post_tax := (.72)*pre_tax;
	end if;
	return post_tax;
end
$$

select empl_name as "Employee", monthly_salary as "Pre Tax Income", applyTax(monthly_salary) as "Post Tax Income"
from employee;

select * from department_spending;

/*
 * update department
 * set monthy_budget = monthly_budget + increase
 * where dept_id = current_id;
 */

create function increaseBudget(increase department.monthly_budget%type, current_id department.dept_id%type)
returns void 
language plpgsql
as $$
begin 
	update department
	set monthly_budget = monthly_budget + increase
	where dept_id = current_id;
end
$$

select increaseBudget(16000,1);
select increaseBudget(6000,3);

-- refactor to fetch budget into a variable and return the new budget 
create function increaseBudget2(increase department.monthly_budget%type, current_id department.dept_id%type)
returns numeric 
language plpgsql
as $$
declare
	current_budget numeric;
begin 
	select monthly_budget into current_budget
	from department
	where dept_id = current_id;

	update department
	set monthly_budget = current_budget + increase
	where dept_id = current_id;
	
	return current_budget + increase;
end
$$

select increaseBudget2(3000,2);

/*
 * We're going to create a function which will attempt to give 
 * an employee a raise but only if there are enough funds in that 
 * employee's department's budget to allow for the raise
 */

create or replace function assessRaise(input_id employee.empl_id%type, raise_amount employee.monthly_salary%type)
returns numeric 
language plpgsql
as $$
declare 
	empl_dept_id employee.dept_id%type;
	dept_budget department.monthly_budget%type;
	budget_used department.monthly_budget%type;
	current_salary employee.monthly_salary%type;
begin
	-- get department id
	select dept_id into empl_dept_id
	from employee
	where empl_id = input_id;
	
	-- get the department budget
	select monthly_budget into dept_budget
	from department
	where dept_id = empl_dept_id;

	-- get the value of the budget already used with employee salaries
	select sum(monthly_salary) into budget_used
	from employee
	where dept_id = empl_dept_id;

	-- get the current salary of the employee 
	select monthly_salary into current_salary
	from employee
	where empl_id = input_id;

	-- we need to compare budget_used + raise_amount to budget
	if (budget_used+raise_amount)>dept_budget then 
		return current_salary;
	else 
		update employee
		set monthly_salary = current_salary + raise_amount
		where empl_id = input_id;
		return current_salary + raise_amount;
	end if; 
end;
$$

select * from department_spending;

select assessRaise(8, 800);