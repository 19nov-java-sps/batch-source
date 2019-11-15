-- * gets all records
-- from chooses where those records come from
--2.1 a
select *
from "Employee" e;

-- * gets all records
-- from chooses where those records come from
-- where limits the records returned that only include the object referenced
--2.1 b
select *
from "Employee" e
where "LastName" = 'King';

-- select title only takes information from the title column
-- from chooses where those records come from
-- order by compares and sorts for you
-- desc means opposite so from z to a
--2.1 c
select "Title"
from "Album" a
order by "Title" desc;

-- select only takes information from the firstname and city columns
-- from chooses where those records come from
-- order by compares and sorts for you
-- nothing after city means its sorted by default or ascending
--2.1 d
select "FirstName", "City"
from "Customer" c
order by "City";

-- * gets all records
-- from chooses where those records come from
--where limits the records returned that only include the object referenced
--where like returns all results that start with T and can have any ending
--2.1 e
select *
from "Invoice" i
where "BillingAddress" like 'T%';

-- select only takes information from the name columns
-- from chooses where those records come from
-- order by compares and sorts for you
-- limit only returns the a specified number of results in this case only the first one
--2.1 f
select "Name"
from "Track" t
order by length("Name") desc
limit 1;

-- select only takes information from the total column
-- avg takes the average of the values from total
-- from chooses where those records come from
--2.1 g
select avg("Total")
from "Invoice" i;

-- select only takes information from the employeeid and title column
-- count takes the total of values in employeeid
-- from chooses where those records come from
-- group by creates a table that is separated by title and has the aggregate sum of each employee with each title
--2.1 h
select count("EmployeeId"), "Title"
from "Employee" e
group by "Title";

-- insert into you need to choose what table to insert into and must specify what inputs you need in that table
-- values are the values input into the table
--2.2 a
INSERT INTO "Genre" ("GenreId", "Name") VALUES (26, N'Boop');

INSERT INTO "Genre" ("GenreId", "Name") VALUES (27, N'Beep');

-- insert into you need to choose what table to insert into and must specify what inputs you need in that table
-- values are the values input into the table
--2.2 b
INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
VALUES (9, N'Voroshylo', N'Bob', N'General Assistant Manager', '1968/2/18', '2002/8/14', N'11120 Jasper Ave NW', N'New York', N'AB', N'Canada', N'T5K 2N1', N'+1 (780) 428-9482', N'+1 (780) 428-3457', N'andrew@chinookcorp.com');

INSERT INTO "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
VALUES (10, N'Goroshylo', N'Gob', N'General Head Manager', '1969/2/18', '2002/8/14', N'11120 Jasper Ave NW', N'Edmonton', N'AB', N'Canada', N'T5K 2N1', N'+1 (780) 428-9482', N'+1 (780) 428-3457', N'andrew@chinookcorp.com');

-- insert into you need to choose what table to insert into and must specify what inputs you need in that table
-- values are the values input into the table
--2.2 c
INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") 
VALUES (60, N'Tim', N'Goyer', N'Apple Inc.', N'1 Infinite Loop', N'Cupertino', N'CA', N'USA', N'95014', N'+1 (408) 996-1010', N'+1 (408) 996-1011', N'tgoyer@apple.com', 3);

INSERT INTO "Customer" ("CustomerId", "FirstName", "LastName", "Address", "City", "State", "Country", "PostalCode", "Phone", "Email", "SupportRepId") 
VALUES (61, N'Dan', N'Miller', N'541 Del Medio Avenue', N'Mountain View', N'CA', N'USA', N'94040-111', N'+1 (650) 644-3358', N'dmiller@comcast.com', 4);

--to update you choose what table to insert into
--to set you choose what values you want to insert into what columns with column = new value
--for where you use same column from where and the value you are replacing column = old value
--2.3a
update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--to update you choose what table to insert into
--to set you choose what values you want to insert into what columns with column = new value
--for where you use same column from where and the value you are replacing column = old value
--2.3b
update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--selects names with invoiceid invoice.invoice is needed to clarify where invoiceid is coming from since invoice is not invoked in from statement
--inner join invoice joins every result set with the same customerid
--3.1
select "FirstName", "LastName", "Invoice"."InvoiceId"
from "Customer"
inner join "Invoice"
on "Invoice"."CustomerId" = "Customer"."CustomerId";

--selects all names and invoice info
--if no name connected to an invoice it returns null for the names
--if no invoice connected to a name it returns null for the invoice information
--3.2
select "Customer"."CustomerId", "FirstName", "LastName", "Invoice"."InvoiceId", "Invoice"."Total"
from "Customer"
full outer join "Invoice"
on "Invoice"."CustomerId" = "Customer"."CustomerId";

--selects all records from table Artist and matches them to album
--using artistid as primary key
--3.3 
select *
from "Album"
right join "Artist"
on "Artist"."ArtistId" = "Album"."AlbumId";

--returns all results #rowsofAlbum*#rowsofArtist as cross join TOTAL ROWS = TABLE1(#rows) * Table2(#rows)
--sorts by name no need to mention ascending as that is default
--3.4
select *
from "Album"
cross join "Artist"
order by "Name";

-- joins all matching records using reportTo and EmployeeId as primary and foreign key
--3.5
select *
from "Employee" e
join "Employee" f
on e."ReportsTo"=f."EmployeeId";



-----3.6-----
-----a-------
-----inner join on customerID as primary key
-----use group by to return sum of total money customers spent
-----order by orders the information to look better

select "FirstName" || "LastName" as full_name, Sum("Total")
from "Customer"
inner join "Invoice"
on "Invoice"."CustomerId" = "Customer"."CustomerId"
group by full_name
order by Sum("Total");

------b-------
-----double inner join first need to find out how employee and sales are linked
-----supportrep is in customer and it references an employee
-----first take info from customer to find out who is sales employee
-----2nd join is to link money to how much customer spent
-----this links employee to money spent
-----group by to sum up how much each employee sold

select "Employee"."FirstName" || "Employee"."LastName" as full_name, sum("Total")
from "Customer"
inner join "Employee"
on "Employee"."EmployeeId" = "Customer"."SupportRepId"
inner join "Invoice"
on "Invoice"."InvoiceId" = "Customer"."CustomerId"
group by full_name;


--------c-------
--------Need 2 inner joins look for what links to both genre and number of purchases
--------Track can link together genre and invoice
--------join all relevant data sets through inner join
--------group by is used to count how many purchases made
--------order by count highest on top through using descending to follow instructions

select "Genre"."Name" as name, Count("Track"."GenreId")
from "Track"
inner join "Genre"
on "Genre"."GenreId"="Track"."GenreId"
inner join "InvoiceLine"
on "InvoiceLine"."TrackId" = "Track"."TrackId"
group by name
order by count desc;


-----------4a------------
-----returns a numeric value
-----declare a variable that you will return must have same type as returns
----just rounds the avg total from invoice and puts it into the variable avgInvoice
----returns variable avgInvoice

create function findAverageInvoice()
returns numeric (7,2)
language plpgsql
as $function$
declare
	avgInvoice numeric (7,2);
begin
	select round(avg("Total")) into avgInvoice
	from "Invoice";
	return avgInvoice;
end
$function$

drop function findAverageInvoice;


select findAverageInvoice();

---------------4b-----------------
------takes an int id to link id to whether or not someone is born after 1968 or is younger than 51 years or 18615 days using interval
------returns true or false given an id
------2 variables 1 to hold how old someone is using timestamp-timestamp = interval 
------1 to hold true or false this is what you return
------current_date gives you todays date and subtracting birthdate returns how old someone is in an interval variable in days
------checks which employee to check through using id as identifier
------use if statement to set true or false depending on how old employee is
------returns true/false

create function howOldEmployee(id int)
returns boolean
language plpgsql
as $function$
declare
	howOld interval;
	howTrue boolean;
begin
	select current_date - "BirthDate" into howOld
	from "Employee"
	where "EmployeeId" = id;
	if howOld > '18615 days' then howTrue := false;
	else howTrue := true;
	end if;
	return howTrue;
end
$function$

drop function howOldEmployee(int);

select howOldEmployee(9);

----------4c-------------
---------takes a employee id
---------returns a varchar managername 40 characters because first name is 20 and last name is 20 so maximum possible characters is 40
---------use self join to link employee id to reports to
---------looks for where employee id is equal to id input
---------returns managername when possible if no manager returns null

create function whoManager(id int)
returns varchar(40)
language plpgsql
as $function$
declare
	managerName varchar(40);
begin
	select m."FirstName" || m."LastName" into managername
	from "Employee" e
	inner join
	"Employee" m on m."EmployeeId" = e."ReportsTo"
	where e."EmployeeId" = id;
	return managername;
end
$function$

drop function whoManager(int);


select whoManager(8);

--------------4d-------------
---------takes in a variable int
---------returns price with cents and declares a price variable to hold sum of tracks
---------use a double inner join to link together playlist price and id of playlist
---------each playlist has multiple values so use a sum and group by to get back a single value

create function findPrice(id int)
returns numeric (7,2)
language plpgsql
as $function$
declare
	price numeric (7,2);
begin
	select Sum("Track"."UnitPrice") into price
	from "PlaylistTrack"
	inner join "Playlist"
	on "Playlist"."PlaylistId" = "PlaylistTrack"."PlaylistId"
	inner join "Track"
	on "Track"."TrackId" = "PlaylistTrack"."TrackId"
	group by "Playlist"."PlaylistId"
	having "Playlist"."PlaylistId" = id;
	return price;
end
$function$

drop function findPrice(int);

select findPrice(18);
