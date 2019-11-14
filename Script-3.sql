--2.1 SELECT

--Select all records from the Employee table.
--select * from "Employee";


--Select all records from the Employee table where last name is King.
--select * from "Employee" where "LastName" = 'King';


--Select all albums in Album table and sort result set in descending order by title.
--select * from "Album" order by "Title" desc;

--Select first name from Customer and sort result set in ascending order by city.
--select "FirstName" from "Customer" order by "City" asc;

--Select all invoices with a billing address like “T%”.
-------Use wildcards
--select * from "Invoice" where "BillingAddress" like 'T%';


--Select the name of the longest track.
-------Can use either subqueries or one query with descending order and only choosing the top
--select "Name" from "Track" where "Milliseconds"=(select max("Milliseconds") from "Track")
--select "Name" from "Track" order by "Milliseconds" desc limit 1;


--Find the average invoice total.
------Use aggregate avg function
--select avg("Total") as Average from "Invoice";


--Find the total number of employees in each position.
--use count* aggregate to get all values and group by to group the positions
--select "Title",count(*) from "Employee" group by "Title";


--2.2 INSERT INTO

--Insert two new records into Genre table
--------inserted values
--insert into "Genre"("GenreId","Name") values (26,'Disco');
--insert into "Genre"("GenreId","Name") values (27,'Birthday');


--Insert two new records into Employee table
--insert into "Employee" ("EmployeeId","LastName","FirstName","Title","BirthDate","HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email")values (9,'Mama','Jo','Owner','2002/8/13', '2002/8/14', '111 NY AVE', 'New York', 'NY', 'USA', '11111','3473626253','+1 (780) 428-3457', '123@aol.com');
--insert into "Employee" ("EmployeeId","LastName","FirstName","Title","BirthDate","HireDate","Address","City","State","Country","PostalCode","Phone","Fax","Email")values (10,'Papa','Jo','CEO','2002/8/12', '2002/8/13', '112 NY AVE', 'New York', 'NY', 'USA', '11111','3473635322','+1 (780) 428-3457', '1234@aol.com');



--Insert two new records into Customer table 
--INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") VALUES (60, 'Paul', 'Smith', N'Embraer - Empresa Brasileira de Aeron�utica S.A.', N'Av. Brigadeiro Faria Lima, 2170', N'Spain city', N'SP', N'Spain', N'123333-000', N'+55 (12) 3923-1111', N'+55 (12) 3923-4322', N'123@aol.com', 3);
--INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") VALUES (61, 'Eric', 'Jones', N'Embraer - Empresa Brasileira de Aeron�utica S.A.', N'Av. Brigadeiro Faria Lima, 2170', N'Mexico city', N'MX', N'Mexico', N'122223-000', N'+55 (12) 3923-2222', N'+55 (12) 3923-5222', N'1235@aol.com', 3);




--2.3 UPDATE

--Update Aaron Mitchell in Customer table to Robert Walter
--update "Customer" set "FirstName"='Robert' , "LastName"='Walter' where "FirstName"='Aaron' and "LastName"='Mitchell';



--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--update "Artist" set "Name"='CCR' where "Name"='Creedence Clearwater Revival'




--3.0 Joins
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--3.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--select "FirstName"|| ' '||"LastName" as "Name", "InvoiceId" from "Customer" inner join "Invoice" on "Invoice"."CustomerId"="Customer"."CustomerId";


--3.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total" from "Customer" full outer join "Invoice" on "Invoice"."CustomerId"="Customer"."CustomerId";


--3.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title.
--select "Artist"."Name", "Album"."Title" from "Album" right join "A" on "Artist"."ArtistId" = "Album"."ArtistId";


--3.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
--select * from "Album" a cross join "Artist" order by "Artist"."Name" asc;


--3.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column.
--select A."EmployeeId",A."LastName",A."FirstName",B."EmployeeId",B."LastName",B."FirstName",B."ReportsTo" from "Employee" A, "Employee" B where A."EmployeeId"=B."ReportsTo"  order by A."EmployeeId";


--3.6 Joined Queries
--Create a query that shows the customer first name and last name as FULL_NAME (you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
--select A."FirstName" ||' ' || A."LastName" as "FULL_NAME", I."Total" as "TOTAL" from "Customer" A join "Invoice" I on A."CustomerId"=I."CustomerId";

--Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
--select A."FirstName" ||' ' || A."LastName" as "FULL_NAME", sum(I."Total") from "Employee" A join "Customer" C on C."SupportRepId"=A."EmployeeId" join "Invoice" I on I."CustomerId"=C."CustomerId" group by "FULL_NAME" order by sum desc limit 1;




--Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
--select G."Name", sum(I."Quantity") as NumberOfPurchases from "Genre" G join "Track" T on G."GenreId"=T."GenreId" join "InvoiceLine" I on I."TrackId"=T."TrackId" group by G."Name" order by NumberOfPurchases desc;


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
As $function$
Begin
	return QUERY select * from "Employee" where "Employee"."BirthDate">'1968-12-31 00:00:00';
End;
$function$

select afterYear()


--Create a function that returns the manager of an employee, given the id of the employee.
create or replace function getManager(emp_id "Employee"."EmployeeId"%type)
returns setof "Employee"
language plpgsql
As $function$
declare
	reports_to "Employee"."ReportsTo"%type;
begin
	Select "ReportsTo" into reports_to from "Employee" where emp_id="EmployeeId";
	return QUERY select * from "Employee" where reports_to="EmployeeId";
End;
$function$

select getManager(2)



--Create a function that returns the price of a particular playlist, given the id for that playlist.
create or replace function getPrice(playlist_id "PlaylistTrack"."PlaylistId"%type)
returns Numeric
language plpgsql
As $function$
declare
	price numeric;
	quantity numeric;
	total numeric;
begin
	select ("UnitPrice") into price from "Track" t join "PlaylistTrack" p on t."TrackId"=p."TrackId" ;
	select count(*) into quantity from "PlaylistTrack" where playlist_id="PlaylistId";
	total=quantity * price;
	return total;
End;
$function$

select getPrice(4);

