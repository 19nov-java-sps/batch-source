-- 2.1a
select * 
from "Employee";
-- 2.1b
select * from "Employee" where "LastName" = 'King';
-- 2.1c
select * from "Album" order by "Title" desc;
-- 2.1d
select "FirstName" from "Customer" order by "City" asc;
-- 2.1e
select * from "Invoice" where "BillingAddress" like 'T%';
-- 2.1g
select avg("Total") from "Invoice";
-- 2.1.h
select count("EmployeeId") from "Employee";

-- 2.2a 
insert into "Genre" values(26, 'KPop');
insert into "Genre" values(27, 'JPop');
-- 2.2.b
insert into "Employee" values(9, 'Louis', 'George', 'Recorder Maker', 2, '1968-02-09 00:00:00', '1999-01-09 00:00:00', '123 Fake Street', 'SpringField', 'AB', 'UnitedStates', '10042', '555-555-555', '555-555-5555', 'fakeEmail@fake.com');
insert into "Employee" values(9, 'Stark', 'Tony', 'Recorder Label', 2, '1958-02-09 00:00:00', '1979-01-09 00:00:00', '1234 Fake Street', 'SpringField', 'AB', 'UnitedStates', '10021', '555-555-555', '555-555-5555', 'fakeEmail@fake.com');
-- 2.2 c
insert into "Customer" values(60, 'Chris', 'Evans', 'Apple', '12 Fake Street', 'New York City', 'New York', 'United States', '12222', '212 555 555', '212 555 5555', 'chrisevan@gmail.com', 3); 
insert into "Customer" values(60, 'Travis', 'Scott', 'Google', '125 Fake Street', 'Albany', 'New York', 'United States', '12222', '212 555 555', '212 555 5555', 'TravisScott@gmail.com', 4); 

-- 2.3a
update "Customer" set "FirstName" = 'Robert' set "LastName" ='Walter' where "CustomerId" = 32;
-- 2.3.b
update "Artist" set "Name" = 'CCR' where "ArtistId" = 76;

-- 3.1a
SELECT "Customer"."CustomerId", "Invoice"."InvoiceId"
FROM "Invoice" 
INNER JOIN "Customer" 
ON "Invoice"."CustomerId" = "Customer"."CustomerId";

-- 3.2a
SELECT "Customer"."CustomerId", "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total"
FROM "Invoice" 
full OUTER JOIN "Customer" 
ON "Invoice"."CustomerId" = "Customer"."CustomerId";

-- 3.3a
select "Album"."Title", "Artist"."Name"
from "Artist"
right join "Album"
on "Artist"."ArtistId" = "Album"."ArtistId"

--3.4a
select *
from "Artist"
cross join "Album"
order by "Artist"."Name" asc;

-- 3.5a
SELECT "a"."EmployeeId", "a"."ReportsTo", "b"."ReportsTo"
FROM "Employee" "a", "Employee" "b"
Where "a"."ReportsTo" <> "b"."ReportsTo";

-- 3.6a
select concat("Customer"."FirstName",' ',"Customer"."LastName") as "Full Name", "Invoice"."Total"
from "Customer"
join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- 3.6b

-- 3.6c

-- 4.0a
create or replace function avgInvoice()
returns integer
language plpgsql
as $Function$
declare
	avgInv numeric(7,2);
begin
	select avg("Total") into avgInv
		from "Invoice";
		return avgInv;
end
$Function$

select avgInvoice();

-- 4.0b
create or replace function findAge()
returns setof "Employee"
language plpgsql
as $Function$
begin
	return query select "Employee".*
	from "Employee" 
	where "Employee"."BirthDate" > '1968-01-01 00:00:00';
end
$Function$

select findAge();

-- 4.0c
create or replace function findManager("empid" "Employee"."EmployeeId"%type)
returns setof "Employee"
language plpgsql
as $Function$
begin
	return query select m."ReportsTo", e."EmployeeId", e."ReportsTo", m."EmployeeId"
	from "Employee" e
	join "Employee" m
	on e."EmployeeId" = "empid";
end
$Function$

drop function findManager(empid "Employee"."EmployeeId"%type);
select findManager(3);

-- 4.0d
create or replace function pricePL(PL "Playlist"."PlaylistId"%type)
returns price
language plpgsql
as $Function$
begin
	
end
$Function$