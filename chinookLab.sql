-- 2.0 QUERIES AND DML


	-- 2.1 SELECT
	-- a
	

select e.*
from "Employee" e;


	-- b


select e.*
from "Employee" e
where E."LastName" = 'King';


	-- c


select a.*
from "Album" a
order by "Title" desc;


	-- d


select c."FirstName"
from "Customer" c
order by "City" asc;


	-- e
	

select i.*
from "Invoice" i
where "BillingAddress" like 'T%';


	-- f


select t."Name", t."Milliseconds"
from "Track" t
where "Milliseconds" = (
	select max("Milliseconds")
	from "Track" t
);


	-- g


select avg(i."Total")
from "Invoice" i;


	-- h


select count(e."EmployeeId") as "Employee Count", e."Title"
from "Employee" e
group by e."Title";


	-- 2.2 INSERT INTO
	-- a
	

insert into "Genre" ("GenreId", "Name") values (26, 'test');
insert into "Genre" ("GenreId", "Name") values (27, 'test2');


	-- b


insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", 
	"BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values (9, 'Doe', 'John', 'Staff', 1, '1992-05-02 00:00:00', '2019-11-14 00:00:00', '123 Numbers Street', 
	'New York', 'NY', 'United States', '11111', '+1 (234) 567-8900', '+1 (098) 765-4321', 'jDoe@gmail.com');

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", 
	"BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values (10, 'Doe', 'Jane', 'Staff', 1, '1993-06-12 00:00:00', '2019-11-12 00:00:00', '1357 Odds Street', 
	'New York', 'NY', 'United States', '11111', '+1 (234) 777-7777', '+1 (098) 555-5555', 'janeDoe@gmail.com');


	-- c


insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", 
	"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values (60, 'Dave', 'Lee', null, '2468 Even Street', 'New York', 'NY', 'United States', 
	'22222', '+1 (234) 666-6666', '+1 (098) 444-4444', 'LeeDave@gmail.com', 2);

insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", 
	"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
values (61, 'Kevin', 'Cruz', null, '0101 Binary Street', 'New York', 'NY', 'United States', 
	'01010', '+1 (234) 0101-1100', '+1 (098) 0101-0001', 'KCruz@gmail.com', 4);


	-- 2.3 UPDATE
	-- a
	

update "Customer"
set "FirstName" = 'Robert'
where "FirstName" = 'Aaron';

update "Customer"
set "LastName" = 'Walter'
where "LastName" = 'Mitchell';


	-- b


update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';


-- 3.0 JOINS


	-- 3.1 INNER
	--a
	

select c."FirstName", c."LastName", i."InvoiceId" from
"Customer" c
inner join "Invoice" i
on c."CustomerId"= i."CustomerId";


	-- 3.2 OUTER
	-- a


select i."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" c
full outer join "Invoice" i
on i."InvoiceId" = c."CustomerId";


	-- 3.3 RIGHT
	-- a
	

select a."Name", al."Title"
from "Artist" a
right outer join "Album" al
on a."ArtistId" = al."ArtistId";


	-- 3.4 CROSS
	-- a
	

select a."Name"
from "Artist" a
cross join "Album"
order by a."Name" asc;


	-- 3.5 SELF
	-- a


select e."FirstName", e."LastName", e."ReportsTo"
from "Employee" e
join "Employee" m
on e."EmployeeId" = m."ReportsTo";


	-- 3.6 JOINED QUERIES
	-- a	(Incomplete)


select c."FirstName" || c."LastName" as "FULL_NAME"
from "Invoice" i, "Customer" c
group by c."CustomerId";


	-- b	(Imcomplete)


select e.*
from "Employee" e
join "Customer" c
on e."EmployeeId" = c."SupportRepId"


	-- c	(Imcomplete)
	

select g."Genre"
from "Genre" g;


-- 4.0 USER DEFINED FUNCTIONS

	-- a
	

create or replace function avgInvoice()
returns integer
language plpgsql
as $function$
declare
	avgInv numeric(7,2);
begin
	select round(avg("Total"),2) into avgInv
	from "Invoice";
	return avgInv;
end
$function$

select avgInvoice();


	-- b
	

create or replace function after1968()
returns setof "Employee"
language plpgsql
as $function$
begin
	return query select e.* 
	from "Employee" e
	where e."BirthDate" > '1967-12-31 00:00:00';
end
$function$

select after1968();


	-- c


create or replace function managerOfEmp()
returns setof varchar
language plpgsql
as $function$
begin
	return query select e."FirstName"
	from "Employee" e
	join "Employee" m 
	on e."EmployeeId" = m."ReportsTo";
end
$function$

select managerOfEmp();


	-- d

