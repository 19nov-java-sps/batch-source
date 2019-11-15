
create or replace function check_dept_id_uniqueness()
returns trigger
language plpgsql as 
$$
declare
	id_count integer;
begin
	select count(dept_id) into id_count
	from department
	where dept_id = new.dept_id;
	
	if id_count>0 then 
		new.dept_id := nextval('department_dept_id_seq');
	end if;	
	
	return new;
end;
$$

create trigger assure_dept_id_uniquness
before insert -- we can also use after/instead of -- insert/update/delete
on department
for each row -- row scoped triggers
execute procedure check_dept_id_uniqueness();


insert into department values (3, 'my new dept',500);


drop function adddept;

CREATE OR REPLACE FUNCTION public.adddept(deptname character varying, budget double precision)
 RETURNS SETOF department
 LANGUAGE plpgsql
AS $function$
declare 
	new_id integer := nextval('department_dept_id_seq'::regclass);
begin
	insert into department values (new_id, deptName, budget);
	return query select * from department where dept_id = new_id;
end
$function$
;

drop function increasebudget

CREATE OR REPLACE FUNCTION public.increasebudget(increase double precision, current_id integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
begin 
	update department
	set monthly_budget = monthly_budget + increase
	where dept_id = current_id;
end
$function$
;


select *
from employee
left join department
on employee.dept_id = department.dept_id;
