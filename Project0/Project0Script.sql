/***************************************
-- Project0
***************************************/
--create table users
drop table Users cascade;
drop table Accounts;

create table Users
(
user_id serial not null ,
first_name varchar (100) not null,
last_name varchar (150) not null,
user_name varchar (15) not null unique,
pass_word varchar (15) not null,
email varchar (100),
constraint PK_user_id primary key (user_id)
);

ALTER TABLE Users
ADD CONSTRAINT user_name_unique UNIQUE (user_name);

--create table accounts

create table Accounts
(
account_id serial not null,
account_type varchar (20) not null,
balance numeric (10,2) not null check (balance >=0),
user_id int not null,
constraint PK_account_id primary key (account_id)
);

--create forign keys
/*ALTER TABLE "Users" ADD CONSTRAINT "PK_user_id"
    FOREIGN KEY ("user_id") REFERENCES "Accounts" ("account_id") ON DELETE NO ACTION ON UPDATE NO ACTION;*/
alter table Accounts add constraint FK_account_id foreign key (user_id)
references Users (user_id);

/*alter table "Users" add constraint "FK_user_id" foreign key ("user_id")
references "Accounts" ("account_id");*/

--create values in tables

insert into Users (first_name, last_name, user_name, pass_word, email) values ('George', 'Sayapin', 'user1', 'pass', 'sayapingeorge@gmail.com');

insert into Accounts (account_type, balance, user_id) values ('primary', 20.00, 1);
	insert into accounts values ('primary', 0.00, 3);

--testing results
select * from Accounts a;
select * from Users u;

--create a triiger for inserting value into User table
create trigger create_account_after_user_creation
after insert 
on users
for each row 
execute procedure addDefaultAccount ();

--creating an additional row in the user table
insert into Users (first_name, last_name, user_name, pass_word, email) values ('Georgiye', 'Say', 'user2', 'pass', 'say@gmail.com');

--create a function which create account when a new user will be created
CREATE OR REPLACE FUNCTION addDefaultAccount () 
 RETURNS trigger 
 LANGUAGE plpgsql
AS $function$
declare
  max_user_id integer;
begin
	select max(user_id) into max_user_id from users;
	insert into accounts (account_type, balance, user_id) values ('primary', 0.00, max_user_id);
	return old;
end
$function$
;

--create a function which is looking for an existing user by the user name
create or replace function findUserIdByUserName (userName varchar)
returns integer
language plpgsql
as $function$
declare
userId varchar;
	begin
		select user_id into userId from users where user_name = userName;
		if (userId is distinct from null)
		then return userId;
		else
		return 0;
		end if;
	end
$function$
;

--test function 
select findUserIdByUserName('user12');
select findUserIdByUserName('user1');

create or replace function findPassWordByUserId (userId integer, pass varchar)
returns boolean
language plpgsql
as $function$
	declare
		validPass varchar;
	begin 
		select pass_word into validPass from users where user_id = userId;
		if (validPass = pass)
			then 
			return true;
		else
			return false;
		end if;
end
$function$
;

create or replace function validateUser (userName varchar, userPass varchar)
returns  boolean
language plpgsql
as $function$
declare 
	userId integer;
	validation boolean;
begin
	select into userId findUserIdByUserName(userName);
	select into validation  findPassWordByUserId(userId,userPass);
	return validation;
end
$function$
;

drop function validateUser;

select validateUser('user1','pass');


select findPassWordByUserId(1, 'pass');

delete from accounts where user_id=12;
delete from users where user_id=12;


drop function findStringValue;