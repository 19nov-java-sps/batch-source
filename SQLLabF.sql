--												SSQL Lab	

--	2.0 Queries and DML
--	2.1 SELECT

--	a	Select all records from the Employee table.
select * 
from "Employee1";

--	b	Select all records from the Employee table where last name is King.
select * 
from "Employee1" 
where "LastName" = 'King';

--	c	Select all albums in Album table and sort result set in descending order by title.
select * 
from "Album"  
order by "Title" DESC;

--	d	Select first name from Customer and sort result set in ascending order by city.
select "Customer"."FirstName"
from "Customer" 
order by "City" asc;

--	e	Select all invoices with a billing address like “T%”.
/*
SELECT * FROM Customers
WHERE CustomerName LIKE 'a%';
 */
select * 
from "Invoice"  
order by "BillingAddress" like'T%';

--	f	Select the name of the longest track.
/*
SELECT MAX(column_name)
FROM table_name
WHERE condition;
 */
SELECT max("Milliseconds")
FROM "Track" ;

--	g	Find the average invoice total.
/*
SELECT AVG(column_name)
FROM table_name
WHERE condition;
 */
SELECT AVG ("Total")
from "Invoice";

--	h	Find the total number of employees in each position.
/*
SELECT COUNT(column_name)
FROM table_name
WHERE condition;
 */
SELECT COUNT("Employee1"."EmployeeId")
from "Employee1" 
GROUP by "Employee1"."Title";

--	2.2 INSERT INTO

--	a	Insert two new records into Genre table
INSERT INTO "Genre" ("GenreId", "Name") 
VALUES (26, 'zouglou');

INSERT INTO "Genre" ("GenreId", "Name") 
VALUES (27, 'zouglou');


--	b	Insert two new records into Employee table
INSERT INTO "Employee1" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", 
			"HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", 
			"Fax", "Email") 
VALUES (200, 'Alpha', 'Blondy', 'General Manager', '1962/2/18', '2002/8/14', 
			'11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', 
			'+1 (780) 428-9482', '+1 (780) 428-3450', 'alpha@chinookcorp.com');
		
INSERT INTO "Employee1" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", 
			"HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", 
			"Fax", "Email") 
VALUES (203, 'Tiken', 'Jah', 'General Manager', '1962/2/18', '2002/8/14', 
			'11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', 
			'+1 (780) 428-9482', '+1 (780) 428-3455', 'Tiken@chinookcorp.com');

--	c	Insert two new records into Customer table 
INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", 
			"City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") 
VALUES (100, 'Sekou', 'Dosso', 'Embraer - Empresa Brasileira de Aeron�utica S.A.', 
		'Av. Brigadeiro Faria Lima, 2170', 'S�o Jos� dos Campos', 'SP', 'Brazil', 
		'12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);


--	2.3 UPDATE
/*
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
 */

--	a	Update Aaron Mitchell in Customer table to Robert Walter

UPDATE "Customer"
SET "FirstName" = 'Aaron', "LastName" = 'Mitchell'
where "FirstName" = 'Aaron';

--	b	Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE "Artist"
SET "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

select "Name"
from "Artist" 
where "Name" ='CCR';

--	3.0 Joins

--	In this section you will be working with combining various tables through the use of joins. 
--	You will work with outer, inner, right, left, cross, and self joins.

--	3.1 INNER
--	a	Create an inner join that joins customers and orders 
--		and specifies the name of the customer and the invoiceId.
/*
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
 */
SELECT "Customer"."FirstName" , "Invoice"."InvoiceId"
from "Customer" 
INNER JOIN "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--	3.2 OUTER
--	a	Create an outer join that joins the customer and invoice table, 
--		specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT "Customer"."CustomerId", "Customer"."FirstName" , "Customer"."LastName", 
		"Invoice"."InvoiceId", "Invoice"."Total"
from "Customer" 
left JOIN "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--	3.3 RIGHT
--	a	Create a right join that joins album and artist specifying artist name and title.
SELECT "Artist"."Name" , "Album"."Title"
from "Album"  
INNER JOIN "Artist"
on  "Artist"."ArtistId"= "Album"."ArtistId" ;

--	3.4 CROSS
--	a	Create a cross join that joins album and artist and sorts by artist name in ascending order.
/*
SELECT * 
FROM table1 
CROSS JOIN table2;
 */
SELECT * 
FROM "Album" 
CROSS JOIN "Artist"
ORDER by "Artist"."Name" ASC;

--	3.5 SELF
--	a	Perform a self-join on the employee table, joining on the reportsto column.
/*
SELECT column_name(s)
FROM table1 T1, table1 T2
WHERE condition;
 */
SELECT "a"."LastName", "b"."LastName", "a"."City"
FROM "Employee1" "a", "Employee1"  "b"
WHERE "a"."City" = "b"."City"
order by "a"."City";

--	3.6 Joined Queries

--	a	Create a query that shows the customer first name and last name as FULL_NAME 
--		(you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
/*
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
 */
SELECT ("Customer"."FirstName" || "Customer"."LastName") as FULL_NAME , "Invoice"."Total"
from "Customer"
INNER JOIN "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

--	b	Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
/*
SELECT MAX(column_name)
FROM table_name
WHERE condition;
 */	
SELECT employee.FirstName, employee.LastName, invoice.Total
from Employee
INNER JOIN Invoice 
/*
 on 
SELECT customer.FirstName, customer.LastName, max(total)
from Customer c
inner JOIN invoice;
on customer.CustomerId = invoice.CustomerId;
 */

/*
SELECT COUNT(column_name)
FROM table_name
WHERE condition;
 */
--	c	Create a query which shows the number of purchases per each genre. 
--		Display the name of each genre and number of purchases. Show the most popular genre first.
/*
SELECT count(invoiceLine.InvoiceLineId)
from  InvoiceLine;

SELECT count(invoiceLine.InvoiceLineId)
from  InvoiceLine
GROUP by invoiceline.TrackId;

SELECT count(invoice.InvoiceId)
from  Invoice;
 */
-- "TrackId", "Name", "Quantity"
SELECT  "Track"."TrackId", "Track"."Name" , "Invoiceline"."Quantity"
from "Track"   
left join "InvoiceLine"
on "Track"."TrackId" = "Invoiceline"."TrackId"
group by "Invoiceline"."TrackId";

--	4.0 User Defined Functions

--	a	Create a function that returns the average total of all invoices.
SELECT AVG("Total")
		from "Invoice";

CREATE or REPLACE FUNCTION avgTotalInvoice ()
RETURNS numeric(7,2)
LANGUAGE plpgsql

as $func$
DECLARE avgOfTotal NUMERIC(7,2);
	BEGIN
		SELECT AVG("Total") into avgOfTotal
		from "Invoice";
		RETURN avgOfTotal;
	END
$func$

select avgTotalInvoice();

--	b	Create a function that returns all employees who are born after 1968.

CREATE or REPLACE FUNCTION employeeBorn1968()                                            									 
RETURNS setof "Employee1"
LANGUAGE plpgsql
as $func$
	BEGIN
		return query select "Employee1"."FirstName", "Employee1"."LastName", "Employee1"."BirthDate"
					 from 	"Employee1"
					 where ("Employee1"."BirthDate" >= '1968-01-10 00:00:00')  and 
						   ("Employee1"."BirthDate" < '1969-01-01 00:00:00');
	end 
$func$

select employeeBorn1968();

--	c	Create a function that returns the manager of an employee, given the id of the employee.

create or replace function managerOfEmployee(idNumber integer)
returns setof employee
language plpgsql

as $returnManagerId$

begin
	return query 	 select  "employee"."manager_id"
					 from 	"employee"
					 where ("employee"."empl_id" = 'idNumber');
end
   $returnManagerId$
   
select managerOfEmployee(8);
	

--	d	Create a function that returns the price of a particular playlist, 
		-- given the id for that playlist.
		
		
create or replace function pricePlaylist (idPlaylist integer )
returns setof "Track"
language plpgsql
as $returnPlaylistPrice$

declare --x  "Playlist"."PlaylistId"%type;
		x  "PlaylistTrack"."TrackId"%type;
		z  "Track"."TrackId"%type;

begin
	select "PlaylistTrack"."TrackId" into x
	from "PlaylistTrack"
	where "PlaylistTrack"."PlaylistId" = 'idPlaylist' ;
	--return x
	
	return query select "Track"."UnitPrice"
	from "Track"
	where "Track"."TrackId" = "x"."TrackId";
	 
end
   $returnPlaylistPrice$
   
select pricePlaylist(2);

