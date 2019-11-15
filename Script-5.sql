--2.0 Queries and DML
--2.1 SELECT

--Select all records from the Employee table.
select *
from "Employee";

--Select all records from the Employee table where last name is King.
select *
from "Employee" 
where "LastName" = 'King';

--Select all albums in Album table and sort result set in descending order by title.
select * 
from "Album"
order by "Title" desc;

--Select first name from Customer and sort result set in ascending order by city.
select "FirstName"
from "Customer"
order by "City" asc;

--Select all invoices with a billing address like “T%”.
select *
from "Invoice"
where "BillingAddress" 
like 'T%';

--Select the name of the longest track.
select "Name"
from "Track"
where "Milliseconds" = 
    (select max("Milliseconds")
   from "Track");

--Find the average invoice total.
SELECT AVG("Total") 
FROM "Invoice";

   
--Find the total number of employees in each position.
select "Title", count(*)
from "Employee"
group by "Title";


--2.2 INSERT INTO
--Insert two new records into Genre table
insert into "Genre" ("GenreId","Name") values(26, 'Dubstep');
insert into "Genre" ("GenreId","Name") values(27, 'Trap');

--Insert two new records into Employee table
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values (9, 'Carstons', 'Ryan', 'IT Staff', 1, '1994-09-01 00:00:00', '2019-10-22 00:00:00', '77-16 66th road', 'Middle Village', 'NY', 'USA', '11379', '+1 (571) 282-9747', '+1 (571) 282-9747', 'carsryan@gmail.com');

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
values (10, 'Freedman', 'Darien', 'IT Staff', 1, '1995-05-24 00:00:00', '2019-10-22 00:00:00', 'Big Baller 123', 'Dallas', 'TX', 'USA', '75001', '+1 (972) 655-4757', '+1 (972) 655-4757', 'darien.freedman@gmail.com');

--Insert two new records into Customer table 
insert into "Customer" ("CustomerId","FirstName","LastName","Company","Address","City","State","Country","PostalCode","Phone","Fax","Email","SupportRepId")
values (60, 'Ryan', 'Carstons', 'Microsoft', 'Big Baller Brand 123', 'Seattle', 'WA', 'USA', '98101', '+1 (571) 282-9747', '+1 (571) 282-9747', 'carsryan@gmail.com', 6);

insert into "Customer" ("CustomerId","FirstName","LastName","Company","Address","City","State","Country","PostalCode","Phone","Fax","Email","SupportRepId")
values (61, 'Darien', 'Freedman', 'Microsoft', 'Big Baller Brand 456', 'Seattle', 'WA', 'USA', '98101', '+1 (972) 655-4757', '+1 (972) 655-4757', 'dairen.freedman@gmail.com', 6);

--2.3 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE "Customer"
SET "FirstName" = 'Robert', "LastName" = 'Walter'
WHERE "CustomerId" = 32;

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE "Artist"
SET "Name" = 'CCR'
WHERE "ArtistId" = 76;


--3.0 Joins
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--3.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT "FirstName", "LastName", "InvoiceId" 
FROM "Invoice"
INNER JOIN "Customer"
on "Customer"."CustomerId" = "Invoice"."InvoiceId";

--3.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT "FirstName", "LastName", "InvoiceId", "Total"
FROM "Customer" 
FULL OUTER JOIN "Invoice"
on "Invoice"."CustomerId" = "Customer"."CustomerId";

--3.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
SELECT "Name", "Title"
FROM "Artist"
right outer join "Album"
on "Artist"."ArtistId" = "Album"."ArtistId";

--3.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT "Name", "Title"
FROM "Artist"
cross join "Album"
order by "Name" asc;

--3.5 SELF
--Perform a self-join on the employee table, joining on the reports to column.
select "e"."FirstName", "e"."LastName", "Employee"."FirstName", "Employee"."LastName",
"e"."ReportsTo"
from "Employee" e
inner join "Employee"
on "Employee"."ReportsTo" = "e"."EmployeeId";

--3.6 Joined Queries
--Create a query that shows the customer first name and last name as FULL_NAME (you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
select "FirstName" || ' ' || "LastName" as FULL_NAME, sum("Total") as "Total"
from "Invoice"
join "Customer"
on "Customer"."CustomerId" = "Invoice"."CustomerId"
group by "Customer"."CustomerId";

--Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
select "Employee"."FirstName" || ' ' || "Employee"."LastName" as "FULL_NAME", sum("Invoice"."Total") 
from "Employee"
join "Customer" 
on "Customer"."SupportRepId" = "Employee"."EmployeeId"
join "Invoice" 
on "Invoice"."CustomerId" = "Customer"."CustomerId"
group by "FULL_NAME"
order by sum desc;
limit 1;

--Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
select
    G."Name",
    sum(I."Quantity") as TotalPurchases
from
    "Genre" G
join "Track" T on
    G."GenreId" = T."GenreId"
join "InvoiceLine" I on
    I."TrackId" = T."TrackId"
group by
    G."Name"
order by
    TotalPurchases desc;

--4.0 User Defined Functions
--Create a function that returns the average total of all invoices.
create or replace function getAvg()
returns numeric (7,2)
language plpgsql
As $function$
declare
    avgTotal numeric(7,2);
Begin
    select avg("Total") into avgTotal from "Invoice";
    return avgTotal;
End;
$function$

select getAvg()
--Create a function that returns all employees who are born after 1968.
create or replace function afterYear() 
returns setof "Employee" 
language plpgsql 
as $function$ 
begin 
    return QUERY
select *
from "Employee"
where "Employee"."BirthDate">'1968-12-31 00:00:00';
end;
$function$

select afterYear()
--Create a function that returns the manager of an employee, given the id of the employee.
create or replace function getManager(emp_id "Employee"."EmployeeId"%type) 
returns setof "Employee" 
language plpgsql 
as $function$ 
declare reports_to "Employee"."ReportsTo"%type;

begin
select "ReportsTo"
into reports_to
from "Employee"
where emp_id = "EmployeeId";
return QUERY
select *
from "Employee"
where reports_to = "EmployeeId";
end;
$function$

select getManager(2)

--Create a function that returns the price of a particular playlist, given the id for that playlist.
create or replace function getPrice(playlist_id "PlaylistTrack"."PlaylistId"%type) 
returns numeric 
language plpgsql 
as $function$ 
declare 
price numeric;
quantity numeric;
total numeric;
begin
select ("UnitPrice")
into price
from "Track" t
join "PlaylistTrack" p 
on t."TrackId" = p."TrackId" ;

select count(*)
into quantity
from "PlaylistTrack"
where playlist_id = "PlaylistId";
total = quantity * price;
return total;
end;
$function$

select getPrice(4);
