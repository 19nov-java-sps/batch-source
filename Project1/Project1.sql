--creates table to hold employee info--
create table users (
	user_id serial constraint user_pk primary key,
	user_name varchar(15) not null unique,
	pass_word varchar(20) not null,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	invoice_id integer,
	is_manager boolean
);



--creates table to hold employee invoice info__
create table invoice (
	invoice_id serial constraint invoice_pk primary key,
	user_id integer references users(user_id),
	amount double precision,
	description varchar(30) not null,
	pending boolean,
	approved boolean,
	denied boolean,
	resolved boolean
);

-- inner join to get employee first and last name from user table using user_id in invoice table--
select users.first_name, users.last_name
from users 
join invoice
on users.user_id = invoice.user_id;

-- insert statements to add new employees and their info into the users table
insert into users(user_name, pass_word, first_name, last_name, invoice_id, is_manager) values ('peternguyen', 'password', 'Peter', 'Nguyen', 1, false);
insert into users(user_name, pass_word, first_name, last_name, invoice_id, is_manager) values ('ryancarstons', 'password2', 'Ryan', 'Carstons', 2, false);
insert into users(user_name, pass_word, first_name, last_name, invoice_id, is_manager) values ('carolynrehm', 'password3', 'Carolyn', 'Rehm', 3, true);


insert into invoice(user_id, amount, description, pending, approved, denied, resolved) values (1, 150.00, 'Relocation to Client', true, false, false, false);
insert into invoice(user_id, amount, description, pending, approved, denied, resolved) values (1, 250.00, 'Associate Travel Expense', false, true, false, true);
insert into invoice(user_id, amount, description, pending, approved, denied, resolved) values (2, 475.00, 'Relocation to Training', true, false, false, false);
insert into invoice(user_id, amount, description, pending, approved, denied, resolved) values (2, 350.00, 'Interview Expense', false, false, true, true);



drop table users cascade;
drop table invoice cascade;
