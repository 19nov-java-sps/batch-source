-------------------------------------------------------------------------------------------
---------------------------------CHINOOK DATABASE SOLUTIONS--------------------------------
--------------------------------------by Kwame Martin--------------------------------------


-------------------------------------------------
----Queries and DML (Data Manipulation Language)
-------------------------------------------------

--------------------SELECT-----------------------

--- a. Select all records from the Employee table.

select *
from "Employee";

--- b. Select all records from the Employee table where last name is King.

select *
from "Employee" 
where "LastName" = 'King';

--- c. Select all albums in Album table and sort result 
--- set in descending order by title.

select *
from "Album" 
order by "Title" desc;

--- d. Select first name from Customer and 
--- sort result set in ascending order by city.

select "FirstName"
from "Customer" 
order by "City" asc;

--- e. Select all invoices with a billing address like “T%”.

select *
from "Invoice" 
where "BillingAddress" 
like 'T%';

--- f. Select the name of the longest track.

select "Name"
from "Track" 
where "Milliseconds" = 
	(select max("Milliseconds") 
	from "Track");

--- g. Find the average invoice total.

select round(avg("Total"), 2) as "Invoice Total"
from "Invoice";

--- h. Find the total number of employees in each position.

select count("EmployeeId") as "Employee Count", "Title" as "Position"
from "Employee" 
group by "Title";



------------------------INSERT INTO-----------------------------


--- a. Insert two new records into Genre table

insert into "Genre" ("GenreId", "Name") values (26, 'Drill');
insert into "Genre" ("GenreId", "Name") values (27, 'Soca');

--- b. Insert two new records into Employee table

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") values (9, 'Martin','Kwame', 'Software Engineer', 6, '1986-09-06', '2019-11-04', '19 Herkimer Street', 'Brooklyn', 'NY', 'United States', '11216', '+ (718) 255 8550', 'N/A', 'kwame.martin.j@gmail.com');
insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") values (10, 'Hill','Juwan', 'Loss Prevention Agent', 1, '1994-08-02', '2019-11-04', '19 Herkimer Street', 'Brooklyn', 'NY', 'United States', '11216', '+ (347) 488 8845', 'N/A', 'waunski4life@gmail.com');

--- c. Insert two new records into Customer table

insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") values (60, 'Hill', 'Juwan', 'Stuy Beds', '19 Herkimer Street', 'Brooklyn', 'NY', 'United States', '11216', '+ (347) 488 8845', 'N/A', 'waunski4life@gmail.com', 2);
insert into "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") values (61, 'Martin', 'Kwame', 'Revature', '19 Herkimer Street', 'Brooklyn', 'NY', 'United States', '11216', '+ (718) 255 8550', 'N/A', 'kwame.martin.j@gmail.com', 6);


------------------------UPDATE--------------------------------------------


--- a. Update Aaron Mitchell in Customer table to Robert Walter

update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "CustomerId" = 32;

--- b. Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';



--------------------------JOINS----------------------------------------------


-----------INNER---------------
--- a. Create an inner join that joins customers and orders and specifies the name of the customer and
--- the invoiceId.

select "Customer"."FirstName" ||' '|| "Customer"."LastName" as "Name", "Invoice"."InvoiceId"
from "Invoice"  
inner join "Customer" 
on "Customer"."CustomerId" = "Invoice"."CustomerId";


------------OUTER----------------
--- a. Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--- firstname, lastname, invoiceId, and total.

select "Customer"."CustomerId" as "ID", "Customer"."FirstName" || ' ' || "Customer"."LastName" as "Name", "Invoice"."InvoiceId", "Invoice"."Total" as "Total"
from "Invoice"  
full outer join "Customer"
on "Customer"."CustomerId" = "Invoice"."CustomerId";



------------RIGHT----------------
--- a. Create a right join that joins album and artist specifying artist name and title.

select "Artist"."Name" as "NAME", "Album"."Title" as "TITLE"
from "Album" 
right outer join "Artist"
on "Artist"."ArtistId" = "Album"."ArtistId";



------------CROSS----------------
--- a. Create a cross join that joins album and artist and sorts by artist name in ascending order.

select "Artist"."Name" as "Artist", "Album"."Title" as "TITLE"
from "Album" 
cross join "Artist"
order by "Artist"."Name" asc;


------------SELF----------------
--- a. Perform a self-join on the employee table, joining on the reportsto column.

select e."FirstName" ||' '|| e."LastName" as "Employee", c."FirstName" ||' '|| c."LastName" as "Reports To"
from "Employee" e
join "Employee" c
on e."ReportsTo" = c."EmployeeId";



------------Joined Queries--------------------------------------
/*
 * a. Create a query that shows the customer first name and 
 * last name as FULL_NAME (you can use
 * || to concatenate two strings) with the total amount 
 * of money they have spent as TOTAL.
 */

select "Customer"."FirstName" || ' ' || "Customer"."LastName" as "FULL NAME", '$' || "Invoice"."Total" as "TOTAL"
from "Customer"
join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";


/*
 * b. Create a query that shows the employee 
 * that has made the highest total value of sales 
 * (total of all invoices).
 */

select "Employee"."FirstName" || ' ' || "Employee"."LastName" as "Employee", '$' || "Invoice"."Total" as "Invoice Sales"
from "Employee" 
join "Invoice"
on "Employee"."EmployeeId" = "Invoice"."CustomerId" -- had to join Employee table to Invoice table using Foreign Key "CustomerId" which exists in Invoice table

where "Invoice"."Total" = 
	(select max("Total")
	from "Invoice");
	


/* c. Create a query which shows the number of purchases per each genre. 
 * Display the name of each genre and number of purchases. 
 * Show the most popular genre first.
 */

select "Genre"."Name" as "Genre", count("InvoiceLine"."InvoiceId") as "Number of Purchases" -- used count to get number of invoice id's which equates to the number of purchases
from "Genre" 
	join "Track" on "Genre"."GenreId" = "Track"."GenreId"
	join "InvoiceLine" on "Track"."TrackId" = "InvoiceLine"."TrackId" -- had to join Genre table to Track table to InvoiceLine table to access InvoiceId
group by "Genre"."Name" -- groups results by Genre 
order by "Number of Purchases" desc; -- shows most popular first by ordering number of purchases in descending order


---------------------------User Defined Functions-----------------------

-- a. Create a function that returns the average total of all invoices.


create or replace function avgTotalInvoices()
returns numeric(7,2)
language plpgsql
as $function$
declare
	avgTotalInvoice numeric(7,2);
begin
	select round(avg("Total"),2) into avgTotalInvoice
	from "Invoice";
	return avgTotalInvoice;
end
$function$

select avgTotalInvoices();

DROP FUNCTION avgtotalofallinvoices();


-- b. Create a function that returns all employees who are born after 1968.

create or replace function employeesBornAfter68()
returns setof "Employee"
language plpgsql
as $function$
begin
	return query select *
	from "Employee" 
	where ("Employee"."BirthDate" > '1968-12-31 00:00:00' );
	
end
$function$

select employeesBornAfter68();

DROP FUNCTION employeesbornafter68();


-- c. Create a function that returns the manager of an employee, given the id of the employee.

create or replace function returnMyManager(emp_id "Employee"."EmployeeId"%type)
returns setof "Employee"
language plpgsql
as $function$ 
declare reports_to "Employee"."ReportsTo"%type;
begin
	select "ReportsTo" into reports_to
	from "Employee" 
	where emp_id = "EmployeeId";
	return query 
	select * from "Employee" 
	where reports_to = "EmployeeId";
	end;
$function$

select returnMyManager(3);



-- d. Create a function that returns the price of a particular playlist, 
-- given the id for that playlist.

create or replace function playlistPrice(playlist_ID "PlaylistTrack"."PlaylistId"%type)
returns numeric(7,2)
language plpgsql
as $function$
declare
	price numeric(7,2);
	quantity integer;
	total numeric(7,2);
begin 
	select "UnitPrice" into price
	from "Track" 
	join "PlaylistTrack"
	on "Track"."TrackId" = "PlaylistTrack"."TrackId";

	select count(*) into quantity
	from "PlaylistTrack" 
	where playlist_ID = "PlaylistTrack"."PlaylistId";
	
	total := price * quantity;
	return total;
end;
$function$


select playlistPrice(5);