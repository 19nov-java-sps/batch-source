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
user_name varchar (15) not null,
pass_word varchar (15) not null,
email varchar (100),
constraint PK_user_id primary key (user_id)
);

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


select * from Accounts a;
select * from Users u;


create trigger create_account_after_user_creation
after insert 
on users
for each row 
execute procedure addDefaultAccount ();


insert into Users (first_name, last_name, user_name, pass_word, email) values ('Georgiye', 'Say', 'user2', 'pass', 'say@gmail.com');


drop function addAccount;

drop function addDefaultAccount;

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



