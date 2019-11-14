
-- 2.0 Queries and DML
-- 2.1 SELECT
-- Select all records from the Employee table.
-- select * from "Employee";

-- Select all records from the Employee table where last name is King.

-- select * from "Employee"
-- where "LastName"='King';

-- Select all albums in Album table and sort result set in descending order by title.

-- select * 
-- from "Album"
-- order by "Title" DESC;

-- Select first name from Customer and sort result set in ascending order by city.

-- select "FirstName" 
-- from "Customer"
-- order by "City" ASC;

-- Select all invoices with a billing address like “T%”.

-- select *
-- from "Invoice" 
-- where "BillingAddress" like 'T%';


-- Select the name of the longest track.

-- select MAX("Milliseconds") from "Track";

-- Find the average invoice total.

-- select AVG("Total") from "Invoice";

-- Find the total number of employees in each position.

-- select COUNT("EmployeeId") from "Employee";


-- 2.2 INSERT INTO
-- Insert two new records into Genre table

-- INSERT INTO "Genre" ("GenreId", "Name") VALUES (26, 'French');
-- INSERT INTO "Genre" ("GenreId", "Name") VALUES (27, 'family friendly');


-- Insert two new records into Employee table
-- INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName") VALUES (9, 'Nguyen', 'Peter');

-- select * from "Employee";

-- INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") VALUES (10, N'Nguyen', N'Nancy', N'Commissions Manager', '1958/12/8', '2002/5/1', N'825 8 Ave SW', N'Calgary', N'AB', N'Canada', N'T2P 2T3', N'+1 (403) 262-3003', N'+1 (403) 262-3322', N'nancy@chinookcorp.com');


-- Insert two new records into Customer table 


-- insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email")
-- values (200, 'Julia', 'Roberts', 'julia@gmail.com');


-- insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email")
-- values (201,'Betty', 'Smalss', 'betty@gmail.com');


-- 2.3 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter

-- update "Customer"
-- set "FirstName"='Robert', "LastName"='Walter'
-- where "CustomerId"=32;


-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

-- update "Artist"
-- set "Name"='CCR'
-- where "Name"='Creedence Clearwater Revival';

-- 3.0 Joins
-- In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 3.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.


-- SELECT *
-- FROM "Customer"
-- JOIN "Invoice" ON 'CustomerId' = 'CustomerId';



-- 3.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

-- select 'Customer.CustomerId', 'Customer.FirstName', 'Customer.LastName', 'Invoice.InvoiceId', 'Invoice.Total'
-- from "Customer"
-- right join "Invoice"
-- on 'Customer.CustomerId' = 'Invoice.CustomerId';



-- 3.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.


-- 3.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
-- 3.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
-- 3.6 Joined Queries
-- Create a query that shows the customer first name and last name as FULL_NAME (you can use || to concatenate two strings) with the total amount of money they have spent as TOTAL.
-- Create a query that shows the employee that has made the highest total value of sales (total of all invoices).
-- Create a query which shows the number of purchases per each genre. Display the name of each genre and number of purchases. Show the most popular genre first.
-- 4.0 User Defined Functions
-- Create a function that returns the average total of all invoices.
-- Create a function that returns all employees who are born after 1968.
-- Create a function that returns the manager of an employee, given the id of the employee.
-- Create a function that returns the price of a particular playlist, given the id for that playlist.
