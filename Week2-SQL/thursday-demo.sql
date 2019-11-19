-- finding the department which our lowest paid employee belongs to

select d.*
from department d
join employee e 
on e.dept_id = d.dept_id
where e.monthly_salary =
	(select min(monthly_salary)
	from employee);

-- highest actually doesn't give us a department becuase our CEO isn't in a department
select d.*
from department d
join employee e 
on e.dept_id = d.dept_id
where e.monthly_salary =
	(select max(monthly_salary)
	from employee);


-- sum of employee salaries based on department, showing department name and money allocated for salaries

select sum(e.monthly_salary) as "Total Spending", d.dept_name as "Department"
from department d 
join employee e
on e.dept_id = d.dept_id
group by d.dept_name;

-- compare department spending to their budget
select sum(e.monthly_salary) as "Total Spending", d.monthly_budget as "Budget", d.dept_name as "Department"
from department d 
join employee e
on e.dept_id = d.dept_id
group by d.dept_name, d.monthly_budget;

/*
 * Creating views
 * - represent saved queries
 * - information in a view is not actually stored in the database
 * 		rather the criteria to access that information is
 * 
 * create view [view name] as 
 * [query]
 * 
 */

create view department_spending as 
select sum(e.monthly_salary) as "Total Spending", d.monthly_budget as "Budget", d.dept_name as "Department"
from department d 
join employee e
on e.dept_id = d.dept_id
group by d.dept_name, d.monthly_budget;

select *
from department_spending;

update employee
set monthly_salary = 4024
where empl_id = 14;

/*
 * Materialized Views
 * - a materialized view, unlike a normal view, actually 
 * 		stores the results in memory
 * - the results are not going to automatically be changed
 * 		when the source data is changed
 * - we can refresh a materialized view to see those changes
 * 
 */

create materialized view department_spending_2 as 
select sum(e.monthly_salary) as "Total Spending", d.monthly_budget as "Budget", d.dept_name as "Department"
from department d 
join employee e
on e.dept_id = d.dept_id
group by d.dept_name, d.monthly_budget;

select * from department_spending;
select * from department_spending_2;

update employee
set monthly_salary = 3800
where empl_id = 7;

refresh materialized view department_spending_2;