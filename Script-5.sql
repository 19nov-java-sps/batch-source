select * from "Employee";--select all from employee table

select * from "Employee" where "LastName"='King';-- selecting everything from employee where lastname is king

select * from "Album" order by "Title" desc;--electing all albums ordered by title in descending order

select "FirstName" from "Customer" order by "City" asc;

select * from "Invoice" where "BillingAddress"='T%'

select max("Milliseconds") as Longest_Track from "Track";

select avg("Total") as Average_for_invoices from "Invoice";

select "Title", count("Title") as position from "Employee" group by "Title";


insert into "Genre" values(999,'Bobby Bluegrass');-- adding a Email
--Fax
--Phone
--PostalCode
--Country
--State
--City
--Address

insert into "Genre" values(1000,'Bobby Dance');

insert into "Employee" values('9','Smith','Elliot','Head Honcho',1, '1969-02-18 00:00:00', '1992-02-18 00:00:00', 
'96a Glenwood Rd', 'Glenwood Landing', 'NY','USA','11547','516-965-6218','516-982-2983','rbucci@oldwestbury.edu');

insert into "Employee" values('9','Smith','Elliot','Head Honcho',1, '1969-02-18 00:00:00', '1992-02-18 00:00:00', 
'96a Glenwood Rd', 'Glenwood Landing', 'NY','USA','11547','516-965-6218','516-982-2983','rbucci@oldwestbury.edu');

insert into "Employee" values('10','Smith','Francois','Assistant',1, '1969-02-18 00:00:00', '1992-02-18 00:00:00', 
'96a Glenwood Rd', 'Glenwood Landing', 'NY','USA','11547','516-965-6218','516-982-2983','smitty@oldwestbury.edu');

INSERT INTO "Customer"
("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
VALUES(60, 'Peter', 'Monahan', 'Monahan Industries', '407 Hopper Ave', 'Ridgewood', 'NJ', 'USA', '07450', '201-233-0233', '201-564-2929', 'heymon@gmail.com', 1);


INSERT INTO "Customer"
("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
VALUES(61, 'Dennis', 'Monahan', 'Monahan Industries', '407 Hopper Ave', 'Ridgewood', 'NJ', 'USA', '07450', '201-233-0363', '201-564-2929', 'heymon99@gmail.com', 2);

update "Customer" set "FirstName"='Aaron', "LastName"='Mitchell' where "FirstName"='Robert'AND "LastName"='Walter';

update "Artist" set "Name"='CCR' where "Name"='Creedence Clearwater Revival';


select "FirstName", "LastName", "InvoiceId" from
"Customer"
inner join "Invoice"
on "Customer"."CustomerId"= "Invoice"."CustomerId";


--Create a right join that joins album and artist specifying artist name and title.




--Create an outer join that joins the customer and 
--invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

select "FirstName", "LastName", "InvoiceId", "Total" from
"Customer"
full outer join "Invoice"
on "Customer"."CustomerId"= "Invoice"."CustomerId";


--Create a right join that joins album and artist specifying artist name and title.

select "Name", "Title" from
"Artist"
right join "Album"
on "Artist"."ArtistId"= "Album"."ArtistId";

--Create a cross join that joins album and artist and sorts by artist name in ascending order.

select "Name", "Title" from
"Artist"
cross join "Album"
order by "Artist"."Name" asc;

,
--Perform a self-join on the employee table, joining on the reportsto column.

select "e"."FirstName", "e"."LastName", "Employee"."FirstName", "Employee"."LastName", "e"."ReportsTo" from "Employee" e
inner join 
"Employee"
on "e"."EmployeeId"="Employee"."ReportsTo";



--Create a query that shows the customer first name and 
--last name as FULL_NAME (you can use || to concatenate two strings) 
--with the total amount of money they have spent as TOTAL.

select "FirstName" || "LastName" as FULL_NAME, sum("Total") as "Total" from "Invoice", "Customer"
where "Customer"."CustomerId"="Invoice"."CustomerId"
group by "Customer"."CustomerId";





--Create a query which shows the number of purchases per each genre. Display the name of each genre and
--number of purchases. Show the most popular genre first.
 --Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
 




 




select SalesTable2."full_name", Max(SalesTable2."total") from SalesTable2
where SalesTable2."total"=(select max(SalesTable2."total") from SalesTable2)
group by SalesTable2."full_name";




create materialized VIEW SalesTable2 AS
select "Employee"."FirstName" || "Employee"."LastName" as Full_Name, "Customer"."SupportRepId",Sum("Total") as Total  from
"Employee"
inner join
"Customer"
on "Employee"."EmployeeId"="Customer"."SupportRepId"
inner join "Invoice"
on "Customer"."CustomerId"= "Invoice"."CustomerId"
group by "Employee"."FirstName","Employee"."LastName", "Customer"."SupportRepId"

--Create a function that returns the average total of all invoices.




--Create a query which shows the number of purchases per each genre. 
--Display the name of each genre and number of purchases. Show the most popular genre firs



create or replace function findAvgSal()
returns numeric(7,2)
language plpgsql
as $function$
declare
	avgSal numeric(7,2);
begin
	select round(avg("Total"),2) into avgSal
	from "Invoice";
	return avgSal;
end
$function$



select findAvgSal();

create or replace function bornAfter()
returns setof "Employee"
language plpgsql
as $function$
begin
	return query select * from "Employee"  where "Employee"."BirthDate">'1967-12-31 00:00:00'::date;
end
$function$

select bornAfter();

--Create a function that returns the manager of an employee, given the id of the employee.

create or replace function getManager(id integer)
returns setof varchar
language plpgsql
as $function$
begin
return query 
select e."FirstName"
from "Employee" e
join "Employee" m 
on e."EmployeeId"= m."ReportsTo"
where m."EmployeeId"= id
group by e."FirstName";



end;
$function$


select getManager(2);


select e."FirstName"
from "Employee" e
join "Employee" m 
on e."EmployeeId"= m."ReportsTo"
where m."EmployeeId"= 2
group by e."FirstName";



--Create a function that returns the price of a particular playlist, given the id for that playlist.



--Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.



