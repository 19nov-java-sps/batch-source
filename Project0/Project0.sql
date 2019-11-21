-- creates client table to hold client bank account info
create table clients (
	user_name varchar(15) not null unique constraint client_pk primary key,
	pass_word varchar(20) not null,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	client_balance numeric(6,2)
);

-- withdraws money from client account
create or replace function withdraw(client clients.user_name%type, withdrawal double precision)
returns void 
language plpgsql
as $function$
begin 
	update clients
	set client_balance = client_balance - withdrawal
	where user_name = client;
end
$function$

select withdraw('bradpitt', 25);

-- deposits money into client account
create or replace function deposit(client clients.user_name%type, deposit double precision)
returns void 
language plpgsql
as $function$
begin 
	update clients
	set client_balance = client_balance + deposit
	where user_name = client;
end
$function$

select deposit('kwamemartinj', 500);


--updates changes to client account
create or replace function updatebalance(client clients.user_name%type, newBalance double precision)
returns integer
language plpgsql
as $function$
begin
	update clients
	set client_balance = newBalance
	where clients.user_name = client;
	return 1;
end
$function$

select updatebalance('bradpitt', 490);


-- deletes table
drop table clients;

-- insert statements to add clients and their bank account info into the table
insert into clients(user_name, pass_word, first_name, last_name, client_balance) values ('kwamemartinj', '200W31stStreet', 'Kwame', 'Martin', 5500);

insert into clients(user_name, pass_word, first_name, last_name, client_balance) values ('juwanhill', 'Herkimer19Apt8', 'Juwan', 'Hill', 2250);

-- select statement to view all the client info entered into the table
select * from clients;

select * from clients where user_name = 'kwamemartinj';
