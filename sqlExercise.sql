--2.1.a
select *
from "Employee" e;

--2.1.b
select *
from "Employee" e
where "LastName" = 'King';

--2.1.c
select *
from "Album" a
order by "Title" desc;

--2.1.d
select "FirstName"
from "Customer" c
order by "City";

--2.1.e
select *
from "Invoice" i
where "BillingAddress" like 'T%';

--2.1.f
select "Name"
from "Track" t
where "Milliseconds" = (
	select max("Milliseconds")
	from "Track" t2
);

--2.1.g
select avg("Total")
from "Invoice" i;

--2.1.h
select count("EmployeeId")
from "Employee" e
group by "Title";

--2.2.a
insert into "Genre" ("GenreId", "Name") values (26, 'Genre1');
insert into "Genre" ("GenreId", "Name") values (27, 'Genre2');

--2.2.b
insert into "Employee" values (9, 'lastName1', 'firstName1', 'IT Staff', null, null, null, null, null, null, null, null, null, null, null);
insert into "Employee" values (10, 'lastName2', 'firstName2', 'IT Staff', null, null, null, null, null, null, null, null, null, null, null);

--2.2.c
insert into "Customer" values (60, 'firstName3', 'lastName3', null, null, null, null, null, null, null, null, 'abc@gmail.com', null);
insert into "Customer" values (61, 'firstName4', 'lastName4', null, null, null, null, null, null, null, null, 'def@gmail.com', null);

--2.3.a
update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--2.3.b
update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--3.1.a
select concat_ws(' ', c."FirstName", c."LastName") as "Name", i."InvoiceId"
from "Customer" c
inner join "Invoice" i
on c."CustomerId" = i."CustomerId";

--3.2.a
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" c
full outer join "Invoice" i
on c."CustomerId" = i."CustomerId";

--3.3.a
select a1."Name", a."Title"
from "Album" a
right join "Artist" a1
on a."ArtistId" = a1."ArtistId";

--3.4.a
select *
from "Album"
cross join "Artist" a
order by a."Name";

--3.5.a
select e."EmployeeId", concat_ws(' ', e."FirstName", e."LastName") as "Empl_Name", e."ReportsTo", e1."EmployeeId", concat_ws(' ', e1."FirstName", e1."LastName") as "Rept_Name"
from "Employee" e
join "Employee" e1
on e."ReportsTo" = e1."EmployeeId";

--3.6.a
select concat_ws(' ', c."FirstName", c."LastName") as "FULL_NAME", i."Total" as "TOTAL"
from "Customer" c
full outer join "Invoice" i
on c."CustomerId" = i."CustomerId";

--3.6.b
select sum(i."Total") as "Total Sales", e."EmployeeId", concat_ws(' ', e."FirstName", e."LastName") as "Name"
from "Customer" c
join "Invoice" i
on c."CustomerId" = i."CustomerId"
join "Employee" e
on c."SupportRepId" = e."EmployeeId"
group by e."EmployeeId"
order by sum(i."Total") desc
limit 1;

--3.6.c
select sum(i."Quantity") as "Number of Purches", g."Name" as "Genre Name"
from "InvoiceLine" i
join "Track" t
on i."TrackId" = t."TrackId"
right join "Genre" g
on g."GenreId" = t."GenreId"
group by g."Name"
order by "Number of Purches" desc nulls last;

--4.0.a
create or replace function avg_total_invoice()
returns numeric(3, 2)
language plpgsql
as $function$
declare
	avg_total "Invoice"."Total"%type;
begin
	select avg("Total") into avg_total
	from "Invoice";
	return avg_total;
end;
$function$

select avg_total_invoice();


--4.0.b
create or replace function empl_born_after()
returns setof "Employee" 
language plpgsql
as $function$
begin
	return query select * from "Employee" where "BirthDate" > '1968-01-01 00:00:00';
end
$function$

select * from empl_born_after();


--4.0.c
create or replace function get_manager(empl_id integer)
returns setof "Employee"
language plpgsql
as $function$
declare
	manager_id "Employee"."EmployeeId"%type;
begin
	select "ReportsTo" into manager_id
	from "Employee" e
	where "EmployeeId" = empl_id;

	return query select * from "Employee" where "EmployeeId" = manager_id;
end
$function$

select get_manager(2);


--4.0.d
create or replace function get_price_playlist(playlist_id integer)
returns numeric
language plpgsql
as $function$
declare
	total_price "Track"."UnitPrice"%type;
begin
	select sum("Track"."UnitPrice") into total_price
	from "Track"
	join "PlaylistTrack"
	on "Track"."TrackId" = "PlaylistTrack"."TrackId"
	where "PlaylistId" = playlist_id;

	return total_price;
end
$function$

select get_price_playlist(1);










