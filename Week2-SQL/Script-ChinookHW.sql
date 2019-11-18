--Queries and DML

--2.1 SELECT

select *
from "Employee" e;

select *
from "Employee" e
where "LastName" = 'King';

select *
from "Album" a
order by "Title" desc;

select "FirstName"
from "Customer" c
order by "City" asc;


select *
from "Invoice" i
where "BillingAddress" like 'T%';

select "Name"
from "Track" t
where "Milliseconds" = (select max ("Milliseconds") from "Track" t);

select avg ("Total")
from "Invoice" i;

select count("EmployeeId"), "Title"
from "Employee" e
group by "Title";

--2.2 INSERT INTO

INSERT INTO "Genre" ("GenreId", "Name") VALUES (26, N'Folks');
INSERT INTO "Genre" ("GenreId", "Name") VALUES (27, N'African Music');


INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") VALUES (9, N'Adamit', N'Andrey', N'General Manager', '1972/2/18', '2002/6/14', N'11121 Jasper Ave NW', N'Edmonton', N'AB', N'Canada', N'T5K 2N1', N'+1 (780) 728-9482', N'+1 (780) 427-3457', N'andrey@chinookcorp.com');
INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") VALUES (10, N'Edwardson', N'Nanny', N'Sales Manager', 1, '1978/12/8', '2004/5/1', N'825 8 Ave SW', N'Calgary', N'AB', N'Canada', N'T2P 2T3', N'+1 (413) 262-3443', N'+1 (413) 262-3322', N'nanny@chinookcorp.com');


INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Phone", "Email", "SupportRepId") VALUES (60, N'Maaj', N'Parsuk', N'12,Community Centre', N'Delhi', N'India', N'110017', N'+91 0124 39883988', N'manoj.pareek@rediff.com', 3);
INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "Country", "PostalCode", "Phone", "Email", "SupportRepId") VALUES (61, N'Pujacen', N'Sraiza', N'3,Raj Bhavan Road', N'Bangalore', N'India', N'560001', N'+91 080 22289999', N'puja_srivastava@yahoo.in', 3);


--2.3 UPDATE

update "Customer"
set "FirstName"='Robert', "LastName"='Walter'
where "FirstName"='Aaron';

update "Artist"
set "Name"='CCR'
where "Name"='Creedence Clearwater Revival';

--3.1 INNER


select c."FirstName", c."LastName", i.*
from "Customer" c
inner join "Invoice" i
on c."CustomerId" = i."CustomerId";


--3.2 OUTER
select c."FirstName", c."LastName", i."InvoiceId", i."Total"
from "Customer" c
full outer join "Invoice" i
on c."CustomerId" = i."CustomerId";

--3.3 RIGHT
select a."Name", al."Title"
from "Artist" a
right join "Album" al
on a."ArtistId" = al."ArtistId";

--3.4 CROSS
select a.*, al.*
from "Artist" a
join "Album" al
on a."ArtistId" = al."ArtistId"
order by a."Name" asc;

--3.5 SELF
select e."LastName", e."Title", m."LastName", m."Title"
from "Employee" e
join "Employee" m
on e."ReportsTo" = m."ReportsTo";

--3.6 Joined Queries

select c."FirstName" || c."LastName" as "FULL_NAME", sum(i."Total") as "TOTAL"
from "Customer" c
join "Invoice" i
on c."CustomerId" = i."CustomerId"
group by c."CustomerId";


-- not sure

-- Carolyn's solution

select e."FirstName", e."LastName", "Total"
from "Employee" e
join
	(select c."SupportRepId", sum(i."Total") as "Total"
	from "Customer" c
	join "Invoice" i
	on c."CustomerId"=i."CustomerId"
	group by c."SupportRepId") as "Totals"
on e."EmployeeId"="Totals"."SupportRepId"
where "Total" = (select max("Total")
	from
		(select c."SupportRepId", sum(i."Total") as "Total"
		from "Customer" c
		join "Invoice" i
		on c."CustomerId"=i."CustomerId"
		group by c."SupportRepId") as "Totals");
	
	select  max("Total") 
	from 
	(select c."SupportRepId", sum(i."Total") as "Total"
		from "Customer" c
		join "Invoice" i
		on c."CustomerId"=i."CustomerId"
		group by c."SupportRepId") as "Totals";

	--my solution
	--shows maximum ammount of sales
	
select max("Total")
from
(select e."FirstName", e."LastName", sum(i."Total") as "Total"
from "Employee" e
join "Customer" c
on c."SupportRepId" = e."EmployeeId"
join "Invoice" i
on c."CustomerId"=i."CustomerId"
group by e."EmployeeId") as "Totals";

-- shows Employee names and sales ammount

select e."FirstName", e."LastName", sum(i."Total") as "Total"
from "Employee" e
join "Customer" c
on c."SupportRepId" = e."EmployeeId"
join "Invoice" i
on c."CustomerId"=i."CustomerId"
group by e."EmployeeId";

--aggrigate

--????
	
-- not sure

select g."Name" as Genre_Name, sum(il."InvoiceLineId") as Purchase_Number
from "Genre" g
join "Track" t
on t."GenreId" = g."GenreId"
join "InvoiceLine" il
on il."TrackId" = t."TrackId"
group by g."Name"
order by Purchase_Number desc;

--User Defined Functions

create function AverInvTotal ()
returns integer
language plpgsql
as $function$
begin 
	return (select avg(i."Total")
	from "Invoice" i);
end
$function$

select AverInvTotal ();


create function BornBefore1968 ()
returns setof employe 
language plpgsql
as $function$
begin 
	return query select * from  "Employee" e where e."BirthDate" <  '1968-01-01'; 
end
$function$


s





